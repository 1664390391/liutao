package javase.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * details:c测试自定义的MyBufferedReader
 *
 * @author lt
 * @date 2018/10/16
 */
public class TestMyBufferedReader {
    public static void main(String [] args){
        //BufferedReader:读。字符输入流缓冲区
        MyBufferedReader bfr = null;
        try {
            //将缓冲区关联一个字符输入流，并确定字符输入流的目的地
            bfr = new MyBufferedReader(new FileReader("testBufferedWriter.txt"));
            int ch;
            while ((ch = bfr.myRead())!= -1){
                System.out.println((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bfr != null){
                try {
                    bfr.myClose();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
