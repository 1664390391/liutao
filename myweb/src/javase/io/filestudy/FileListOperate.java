package javase.io.filestudy;

import javase.io.filestudy.filter.SuffixFilenameFilter;

import java.io.File;

/**
 * details:文件目录的相关操作
 *
 * @author lt
 * @date 2018/10/24
 */
public class FileListOperate {
    public static void main(String [] args){
        //测试操作目录基本展示
//        TestListRoot();
        //测试各种路径的写法
//        TestListRootByPath();
        //根据过滤器得到文件列表
//        getFileListByFilter();
        //使用递归的方式，深度遍历文件夹
//        getFileAllList();
        //删除一个文件夹的所有内容，直接delete()是失败的，因为文件夹里面不是空的
        deleteFileAllList();
    }

    /**
     * 删除一个文件夹的所有内容
     */
    private static void deleteFileAllList() {
        //得到需要遍历的文件夹对象
        File file = new File(".\\copytestDir1");
        deleteFileList(file);
    }

    /**
     * 使用递归的方式删除文件夹的所有内容
     * 如果想删除的话就进行深度遍历，判断每个文件对象是文件夹还是文件
     * 如果是基本文件，直接删除，如果是文件夹，递归的方式调用直到判断没有子目录的文件夹之后，再将当前的文件夹删除并返回
     * @param file
     */
    private static void deleteFileList(File file) {
        //得到当前文件对象的所有子文件的对象
        File [] files = file.listFiles();
        for (File f : files) {
            //如果是目录，继续往下遍历
            if(f.isDirectory()){
                deleteFileList(f);
            }else{
                //如果不是目录，就是一普通文件，删除
                System.out.println(f+"文件是否被删除："+f.delete());
            }
        }
        //遍历完所有的子文件之后，删除本尊
        System.out.println(file+"文件夹夹夹夹是否被删除："+file.delete());

    }

    /**
     * 深度遍历一个文件夹
     * 1、因为需要深度遍历一个文件夹，所以仅仅得到文件的名称是不足以判断所有信息的，所以需要使用FIle对象的listFiles()得到所有的文件夹对象
     * 2、得到文件夹对象的时候在进行判断，是文件夹则继续遍历下一级，否则打印出文件信息
     * 3、得到文件夹继续遍历下一级的方式和当前一样，所以使用简单的递归即可
     */
    private static void getFileAllList() {
        //得到需要遍历的文件夹对象
        File file = new File(".\\testDir1");
        //进行深度遍历
        int level = 0;
        getFileList(file,level);

    }

    /**
     * 根据传入的文件对象，使用递归的思想进行深度的遍历
     * @param file
     */
    private static void getFileList(File file,int level) {
        //得到文件对象下面所有的子文件(夹)，然后遍历
        File [] subFiles = file.listFiles();
        System.out.println(getSpace(level)+file.getName());
        level++;
        for(int i = 0;i< subFiles.length;i++){
            //判断每个子文件的属性，是文件夹的话则继续遍历
            if(subFiles[i].isDirectory()){
                getFileList(subFiles[i],level);
            }else{
                System.out.println(getSpace(level)+subFiles[i].getName());
            }

        }
    }

    private static String getSpace(int level) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< level;i++){
            sb.append("    ");
        }
        return sb.toString();
    }


    /**
     * 根据过滤器得到文件列表
     */
    private static void getFileListByFilter() {
        File file = new File(".");
        //使用自定义的文件后缀名过滤器
        String [] names = file.list(new SuffixFilenameFilter(".txt"));
        for (String name : names) {
            System.out.println("存在过滤后的文件目录："+name);
        }
    }

    /**
     * 测试各种路径的写法，绝对路径是写死的，不予测试
     */
    private static void TestListRootByPath() {
        //什么都没有
//        File file = new File("");
        // " . "和".\\" 都表示当前相对路径
//        File file = new File(".");
//        File file = new File(".\\");
        //".." 表示上一级目录
        File file = new File("..");
        String [] names = file.list();
        for (String name : names) {
            System.out.println("存在下一级目录"+name);
        }

    }

    /**
     * 测试操作目录
     */
    private static void TestListRoot() {
        //得到所有的根目录并操作
        File[] files = File.listRoots();
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



}
