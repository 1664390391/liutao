package javase.io.streamstudy;

import java.io.FileReader;
import java.io.IOException;

/**
 * details:
 *
 * @author lt
 * @date 2018/10/15
 */
public class FileReaderDemo {
    public static void main(String [] args){
        //测试一个简单的文件读取,一个一个字符读取
//        testReaderBySingle();

        //测试一个简单的文件读取，使用字符数组进行读取
        testReaderByArr();

    }

    private static void testReaderByArr() {
        //1、创建一个文件读取流，关联上目标文件，并进行异常处理
        FileReader fr = null;
        try {
            fr = new FileReader("testWriter.txt");
            //2、使用Reader中的read(char [] buf)进行处理，创建两个变量，一个记录每次读取到字符的数量长度，一个初始的字符集合进行保存每次读取到的数据
            char [] buf = new char[3];
            int len ;
            while ((len = fr.read(buf))!= -1){
                //为啥使用0,len，因为最后一次读取数据未必是一个满的char[]，使用len确定读取到的长度
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {e.printStackTrace();}finally {
            try {fr.close();} catch (IOException e) {e.printStackTrace();}
        }
    }

    private static void testReaderBySingle() {
        //1、创建一个文件读取流，关联上目标文件，并进行异常处理
        FileReader fr = null;
        try {
            fr = new FileReader("testWriter.txt");
            //2、使用Reader中的read()进行处理，read()一次只能读取一个字符的二进制，并且返回值是字符的对应字符编码
            int ch = 0;
            while ((ch = fr.read())!= -1){
                System.out.println((char)ch);
            }
        } catch (IOException e) {e.printStackTrace();}finally {
            try {
                if(fr!= null)
                    fr.close();
            } catch (IOException e) {e.printStackTrace();}
        }
    }
}
