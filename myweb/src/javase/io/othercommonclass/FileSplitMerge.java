package javase.io.othercommonclass;

import javase.io.filestudy.filter.SuffixFilenameFilter;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

/**
 * details:测试文件的切割和合并
 *
 * @author lt
 * @date 2018/10/29
 */
public class FileSplitMerge {
    private static final int SIZE = 1024*1024;

    private static final String filepath = "D:\\liutao\\壁纸\\玉漱白冰\\";

    public static void main(String [] args) throws IOException {

        File file = new File(filepath+"玉漱8.png");
        //要写入的路径
        File dir = new File(filepath+"\\upgradepartlist");
        //为什么循环的次数是(总长度+(每个文件单位-1))/每个单位呢？
        //因为如果长度正好是n*size ，那么相除得到n
        //如果长度是不是整数，那么按照java 的计算方式会将取到的浮点数转型，去掉后面的小数点，所以需要加额外的(SIZE-1)的长度保证之前得到正确的循环次数
        System.out.println("一共需要循环次数："+(file.length()+(SIZE-1))/SIZE);
        //测试文件的切割
//        FileSplit(file);
        //测试文件的合并
//        MergeFile(file);

        //文件切割之后怎么判断有几个碎片？怎么判断之前文件的名称？MergeFile的时候可不会将源文件的信息传给你哦
        //这时候需要升级文件切割的方法，将这些信息保存到切割目录的配置文件中，以便于合并文件时候的读取
//        UpgradeFileSplit(file);

        //升级文件切割方法之后，文件合并也要读取相关的配置信息进行处理了
        UpgradeMergeFile(dir);


    }

    /**
     * 升级版的文件合并，读取切割文件的配置文件，这里应该将这些小功能都封装成函数在操作才正常
     * 1、获取指定文件目录下配置文件对象，并进行健壮性判断
     * 2、得到文件碎片和文件的配置信息，然后进行读写
     * @param dir
     */
    private static void UpgradeMergeFile(File dir) throws IOException {
        //使用过滤器得到碎片文件目录下配置文件数据
        File [] files = dir.listFiles(new SuffixFilenameFilter(".properties"));
        if(files.length != 1){
            throw new RuntimeException("配置文件信息错误");
        }
        //使用Properties集合将配置文件信息加载出来
        Properties prop = new Properties();
        prop.load(new FileInputStream(files[0]));
        String filename = prop.getProperty("filename");
        int count = Integer.parseInt(prop.getProperty("split_count"));

        //判断切割文件的信息正确性，得到写入路径下所有的part文件
        File [] splitFiles = dir.listFiles(new SuffixFilenameFilter(".part"));
        if(splitFiles.length != (count-1)){
            throw new RuntimeException("文件碎片错误");
        }

        //将文件碎片和配置信息拿到，进行读写
        Vector<FileInputStream> vector = new Vector<>();
        for(int i = 0;i<splitFiles.length;i++){
            //将每个文件塞入集合中
            vector.add(new FileInputStream(splitFiles[i]));
        }
        Enumeration<FileInputStream> en =  vector.elements();
        //使用序列流将所有转换成枚举类型的文件输入流封装起来
        SequenceInputStream sis = new SequenceInputStream(en);
        //确定目的地，使用文件对象将目的地的位置已经文件名称确认好
        FileOutputStream fos = new FileOutputStream(new File(dir,filename));
        //不断的读写
        int len;
        byte [] buf = new byte[1024];
        while ((len = sis.read(buf))!= -1){
            fos.write(buf,0,len);
            fos.flush();
        }
        fos.close();
        sis.close();

    }

    /**
     * 升级文件的切割，在切割的时候将文件切割之后的一些基本信息保存下来
     * 这时候想要保存一些数据，又要和流关联，那么就想到properties这个集合流操作
     * @param file
     */
    private static void UpgradeFileSplit(File file) throws IOException {
        //因为不明确文件是纯文本还是其他类型的文件，所以使用字节输入流读取文件
        FileInputStream fis = new FileInputStream(file);
        //将源文件名根据后缀名切割出来，拿到文件的原始名称
        String [] strs = file.getName().split("\\.");

        //创建一个1M的字节缓冲区，当然，也可以不这么大，例如每次缓冲区100k，循环10次每次接着原来的的输出文件继续写，10次之后再换一个输出流也可以
        byte [] buf = new byte[SIZE];
        int len;
        int count = 1;
        //确定输出的位置
        File outdir = new File(file.getParent()+"\\upgradepartlist");
        if(!outdir.exists()){
            outdir.mkdirs();
        }
        //要进行文件的切割，那么要将基本的信息保存下来
        Properties prop = new Properties();
        //循环读取，分别使用输出流输出到新文件夹中
        while((len = fis.read(buf))!= -1){
            //使用输出流将文件输出到指定的位置
            //后缀名自定义，可以根据自己的软件来确定
            new FileOutputStream(new File(outdir,strs[0]+"_"+(count++)+".part")).write(buf,0,len);
        }
        prop.setProperty("split_count",count+"");
        prop.setProperty("filename",file.getName());
        //使用一个输出流，将集合的文件写入,保存位置也就是文件切割的位置
        prop.store(new FileOutputStream(new File(outdir,count+".properties")),"save txt info");
        fis.close();
    }

    /**
     * 测试文件的合并
     * 思路:想要将文件合并，两个方式，第一个方式，找到所有的碎片，分别使用输入流读取出来，然后写到一个文件中去，但是，每个输入流都需要进行单独的写入判断等，非常麻烦！
     * 1、注意后缀名为原来的文件后缀名，2、写文件的输出流构造参数要确定可以进行续写
     * 第二种方式，将所有的随便使用输入流，然后全部装进一个序列流中统一写入
     * @param file
     */
    private static void MergeFile(File file) throws IOException {
        String [] strs = file.getName().split("\\.");

        Vector<FileInputStream> vector = new Vector<>();
        for(int i = 1;i<=((file.length()+(SIZE-1))/SIZE);i++){
            vector.add(new FileInputStream(new File(file.getParent()+"\\partlist",strs[0]+"_"+i+".part")));
        }
        //将碎片找到，这里其实应该根据原文件大小进行判断动态书写的，这里懒就直接写死了
//        FileInputStream fis1 = new FileInputStream(filepath+"partlist\\玉漱8_1.part");
//        FileInputStream fis2 = new FileInputStream(filepath+"partlist\\玉漱8_2.part");
//        FileInputStream fis3 = new FileInputStream(filepath+"partlist\\玉漱8_3.part");
//        vector.add(fis1);
//        vector.add(fis2);
//        vector.add(fis3);
        //将集合中的数据转成枚举类型，供序列流使用
        Enumeration<FileInputStream> en =  vector.elements();
        //使用序列流将所有转换成枚举类型的文件输入流封装起来
        SequenceInputStream sis = new SequenceInputStream(en);
        //确定目的地
        FileOutputStream fos = new FileOutputStream(file.getParent()+"\\partlist\\"+file.getName(),true);
        //不断的读写
        int len;
        byte [] buf = new byte[1024];
        while ((len = sis.read(buf))!= -1){
            fos.write(buf,0,len);
            fos.flush();
        }
        fos.close();
        sis.close();

    }

    /**
     * 测试文件的切割，按照1M为一个碎片
     * 思路
     * 1、读取流关联源文件
     * 2、将读取流的数据创建指定大小的缓冲区以便分批切入
     * 3、每次都是使用新的输出流关联文件对象
     * @param file
     */
    private static void FileSplit(File file) throws IOException {
        //因为不明确文件是纯文本还是其他类型的文件，所以使用字节输入流读取文件
        FileInputStream fis = new FileInputStream(file);
        //将源文件名根据后缀名切割出来，拿到文件的原始名称
        String [] strs = file.getName().split("\\.");

        //创建一个1M的字节缓冲区，当然，也可以不这么大，例如每次缓冲区100k，循环10次每次接着原来的的输出文件继续写，10次之后再换一个输出流也可以
        byte [] buf = new byte[SIZE];
        int len;
        int count = 1;
        //确定输出的位置
        File outdir = new File(file.getParent()+"\\partlist");
        if(!outdir.exists()){
            outdir.mkdirs();
        }
        //循环读取，分别使用输出流输出到新文件夹中
        while((len = fis.read(buf))!= -1){
            //使用输出流将文件输出到指定的位置
            //后缀名自定义，可以根据自己的软件来确定
            new FileOutputStream(new File(outdir,strs[0]+"_"+(count++)+".part")).write(buf,0,len);
        }
        fis.close();

    }
}
