package javase.io.filestudy;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * details:获取指定目录下，指定的文件扩展名。包括子目录，将这些文件的绝对路径写到一个文本文件中
 * 1、必须进行深度遍历
 * 2、如果是文件夹，继续调用遍历文件夹的方法，否则就将普通的文件进行筛选，符合的话存起来
 * 3、将存起来的file对象集合，进行输出流的写入到目的地中。
 *
 * @author lt
 * @date 2018/10/28
 */
public class GetMatchFile {
    public static void main(String [] args){
        //使用递归的思想，深度遍历指定的文件夹，并将所有符合的数据保存起来
        List<File> list = new ArrayList<>();
        File dir = new File(".\\src\\javase\\io");
        System.out.println(dir.getAbsolutePath());
        getMatchFileList(dir,new FilenameFilter(){
            //直接定义过滤器
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        },list);
        for (File file : list) {
            System.out.println(file.getAbsolutePath());
        }
        //使用字节、字符输出流输出到目的地文件中，代码暂时省略

    }

    /**
     * 使用递归的思想，将符合条件的数据保存起来
     * @param dir
     * @param filenameFilter
     * @param list
     */
    private static void getMatchFileList(File dir, FilenameFilter filenameFilter, List<File> list) {
        //得到该目录的子文件的集合
        File [] files = dir.listFiles();
        for (File file : files) {
            //是目录继续往下找，否则找到符合的数据并存入
            if(file.isDirectory()){
                getMatchFileList(file,filenameFilter,list);
            }else{
                //使用文件过滤器的类，将要过滤的文件对象和文件名丢进去
                if(filenameFilter.accept(file,file.getName())){
                    list.add(file);
                }
            }
        }
    }


}
