package javase.io.streamstudy;

import java.io.*;

/**
 * details:测试复制文件，将一个文件从一个位置复制到另一个指定的位置
 *
 * @author lt
 * @date 2018/10/15
 */
public class CopyTextDemo {
    public static void main(String [] args){
//        copyByReaderAndWriter();
        copyByBuffered();


    }

    private static void copyByBuffered() {
        //创建字符输入、输出缓冲区
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("testBufferedWriter.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("testCopy.txt"));
            //频繁的进行读写操作,虽然这里缓冲区的read()相对原生的字符流的read()方法效率快很多，但是既然是字符
            //就可以使用特有的操作行的方法，还可以进行关键字的过滤等操作
            String line;
            while ((line = bufferedReader.readLine())!= null){
                if(line.contains("2")){
                    System.out.println(line);
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //4、关闭两个流
            try {
                if(bufferedReader != null){
                    bufferedReader.close();
                }
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void copyByReaderAndWriter() {
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
