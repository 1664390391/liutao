package javase.io.streamstudy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * details:测试简单的BufferedWriter使用方式
 *
 * @author lt
 * @date 2018/10/16
 */
public class BufferedWriterDemo {
    public static void main(String [] args){
        //BufferedWriter:提供字符输出流缓冲区，进行高效的写入
        BufferedWriter bfw = null;
        try {
            //1、创建一个字符输出流缓冲区，关联一个输出流对象
            bfw = new BufferedWriter(new FileWriter("testBufferedWriter.txt"));
            //2、进行高效的写入
            for(int i = 0;i< 3;i++){
                bfw.write("testBufferedWriter"+i);
                //使用BufferedWriter封装的系统换行功能以及每次都刷新流，进行报错
                bfw.newLine();
                bfw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bfw != null){
                try {
                    //关闭缓冲区，就是关闭字符流对象，缓冲区不是流，是封装流的对象，操作的还是流
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
