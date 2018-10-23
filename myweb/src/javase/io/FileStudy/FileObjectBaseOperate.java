package javase.io.FileStudy;


import javax.xml.soap.SOAPPart;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;

/**
 * details:测试File对象的简单使用
 *
 * @author lt
 * @date 2018/10/23
 */
public class FileObjectBaseOperate {
    public static void main(String [] args) throws IOException {
        //测试获取的一些常用方法
//        TestGet();
        //测试创建和删除
//        TestCreateAndDelete();
        //测试判断
//        TestJudgment();
        //测试重命名，类似于剪切的动作
//        TestRenameTo();
        //测试操作目录
        TestListRoot();
    }

    /**
     * 测试操作目录
     */
    private static void TestListRoot() {
        //得到所有的根目录并操作
        File [] files = File.listRoots();
        for (File file : files) {
            System.out.println(file.getAbsolutePath()+"盘还剩余"+file.getFreeSpace()/(1024*1024*1024)+"G");
            //可以进一步进行排序等操作
        }

        /*
        list()获取当前目录下一级的文件以及文件夹名称，包含隐藏文件
        1、调用list的方法的File对象中封装/访问的必须是目录。不能是文件，一些系统级的目录可能也访问不到
        否则list返回null
        2、如果目录存在但是没有任何内容，则返回一个长度为0的数组
        所以：在得到目录list之后要进行健壮性的判断！
         */
        File file = new File("testDir1\\testDir2\\testDir3\\aaaa");
        String [] names = file.list();
        if(names == null){
            System.out.println("该目录不存在!");
        }else if (names.length == 0){
            System.out.println("该目录下一级为空！");
        }else{
            for (String name : names) {
                System.out.println("存在下一级目录"+name);
            }
        }
    }

    private static void TestRenameTo() {
        File f1 = new File("fileObjectTest.txt");
        File f2 = new File("fileObjectTest2.txt");
        //将f1位置为文件剪切到f2位置上,如果没有文件或者失败返回false
        boolean b = f1.renameTo(f2);
        System.out.println(b);
    }

    /**
     * 测试判断的基本使用
     */
    private static void TestJudgment() {
        //创建一个新的文件对象，可能是一个文本，也可能是一个文件夹
        File file = new File("test");
        //判断是否存在
        System.out.println(file.exists());
        File file1 = new File("testWriter.txt");
        //判断是否存在
        System.out.println(file1.exists());
        //一般判断完是否存在之后再判断是文件还是目录
        if(file1.exists()){
            System.out.println("是否是文件："+file1.isFile());
            System.out.println("是否是目录："+file1.isDirectory());
        }else {
            System.out.println("该文件对象存在");
        }



    }

    /**
     * 测试文件和文件夹的创建和删除
     */
    private static void TestCreateAndDelete() throws IOException {
        //简单的创建和删除文件
//        File file = new File("test.txt");
//        boolean b = file.createNewFile();
//        boolean b = file.delete();

        //测试单级文件夹的删除和创建
//        File file = new File("testdir");
//        boolean b = file.mkdir();
//        boolean b = file.delete();

        //测试多级文件夹的删除和创建
        File file = new File("testDir1\\testDir2\\testDir3");
        //如果对文件进行流的操作，但是最后想删除文件，使用delete()未必能访问的到，流出现异常的话临时文件就不会被删除了
        //这时创建文件的时候使用deleteOnExit()在程序退出的时候删除创建的文件
//        file.deleteOnExit();
        //使用mkdir()无法创建多个文件夹
//        boolean b = file.mkdir();
        boolean b = file.mkdirs();
        //测试多级文件的删除
//        System.out.println(file.getName());
//        boolean b = file.delete();//delete()删除多级文件时，testDir1\testDir2\testDir3，只删除最后一级,因为这里file对象操作的就是最后一级文件目录
//        System.out.println(b);

    }

    /**
     * 测试获取的常用方法
     * 1、获取文件名称
     * 2、获取文件路径
     * 3、获取文件大小
     * 4、获取文件的修改时间
     */
    private static void TestGet() {
        //可以写相对路径或者绝对路径
        File file = new File("testBufferedWriter.txt");
        String name = file.getName();
        String absPath = file.getAbsolutePath();//绝对路径
        String path = file.getPath();//就是你File中填写的文件名称
        long len = file.length();
        long len1 = file.getUsableSpace();//文件所在位置的可用空间的字节数量，/1024就是可用多少K
        long time = file.lastModified();
        //获取时间格式器
        DateFormat dataFormat = DateFormat.getDateTimeInstance();
        String lastModifiedTime = dataFormat.format(time);

        System.out.println("name:"+name);
        System.out.println("absPath:"+absPath);
        System.out.println("path:"+path);
        System.out.println("len:"+len);
        System.out.println("该盘符可用空间:"+len1/(1024*1024*1024)+"G");
        System.out.println("lastModifiedTime:"+lastModifiedTime);

    }
}
