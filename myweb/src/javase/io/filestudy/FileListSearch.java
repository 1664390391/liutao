package javase.io.filestudy;

import java.io.File;

/**
 * 文件目录查找
 * Created by 16643 on 2018/11/8.
 */
public class FileListSearch {
    public static void main(String [] args){
        String pathName = "F:\\java学习\\02、第二阶段 Java web(24天)";
        String endWith = ".avi";
        //得到需要遍历的文件夹对象
        File file = new File(pathName);
        //进行深度遍历
        int level = 0;
        getFileList(file,level,endWith);
    }
    /**
     * 根据传入的文件对象，使用递归的思想进行深度的遍历
     * @param file
     * @param endWith
     */
    private static void getFileList(File file, int level, String endWith) {
        //得到文件对象下面所有的子文件(夹)，然后遍历
//        File [] subFiles = file.listFiles();
        //根据名称过滤
        File [] subFiles = file.listFiles();
//        打印文件夹名称
//        System.out.println(getSpace(level)+file.getName());
        level++;
        for(int i = 0;i< subFiles.length;i++){
            //判断每个子文件的属性，是文件夹的话则继续遍历
            if(subFiles[i].isDirectory()){
                getFileList(subFiles[i],level, endWith);
            }else{
                if(subFiles[i].getName().endsWith(endWith)){
                    if(subFiles[i].getName().contains("注解")){
                        System.out.println("-------------------------");
                        System.out.println("-------------------------");
                        System.out.println("-------------------------");
                    }
                    if(subFiles[i].getName().contains("枚举")){
                        System.out.println(getSpace(level)+file.getAbsolutePath());
                    }
                    System.out.println(getSpace(level)+subFiles[i].getName());
                }

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

}
