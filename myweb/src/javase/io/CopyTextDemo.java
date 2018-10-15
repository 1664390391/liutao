package javase.io;

import java.io.*;

/**
 * details:测试复制文件，将一个文件从一个位置复制到另一个指定的位置
 *
 * @author lt
 * @date 2018/10/15
 */
public class CopyTextDemo {
    public static void main(String [] args){
        //1、创建一个文件输入（读取）流，关联原始文件
        FileReader fr = null;
        //2、创建一个文件输出（写入）流，创建目的地
        FileWriter fw = null;
        try {
            fr = new FileReader("testWriter.txt");
            fw = new FileWriter("testWriter1.txt");
            //3、频繁的进行读写操作,定义两变量，一个是字符数组，记录每次读取一定量的数据，另一个数每次读取的长度
            char [] buf = new char[1024];
            int len ;
            while ((len = fr.read(buf))!= -1){
                fw.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、关闭两个流
            try {
                if(fr != null){
                    fr.close();
                }
                if(fw != null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
