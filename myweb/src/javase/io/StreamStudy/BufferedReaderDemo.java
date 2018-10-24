package javase.io.streamstudy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * details:测试BufferedReader的简单使用
 *
 * @author lt
 * @date 2018/10/16
 */
public class BufferedReaderDemo {
    public static void main(String [] args){
        //BufferedReader:读。字符输入流缓冲区
        BufferedReader bfr = null;
        try {
            //将缓冲区关联一个字符输入流，并确定字符输入流的目的地
            bfr = new BufferedReader(new FileReader("testBufferedWriter.txt"));
            //可以使用数组进行读取，也可以使用特有方法readline,这里数组的方式比较二逼，因为我已经使用缓冲区对象了，又自己建立了一个
            char [] buf = new char[1024];
            int len;
            while ((len = bfr.read(buf))!= -1){
                System.out.println(new String(buf,0,len));
            }
            //使用第二种方式
            String line ;
            while ((line = bfr.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bfr != null){
                try {
                    bfr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
