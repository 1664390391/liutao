package javase.io.othercommonclass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * details:纯操作内存的流对象，内部维护的是一个字节数组
 * 同理还有CharArrayReader、CharArrayWriter、StringReaderm、StringArrayWriter操作的事字符、字符串数组缓冲区
 *
 * @author lt
 * @date 2018/10/30
 */
public class ByteArrayStreamDemo {
    public static void main(String [] args){
        ByteArrayInputStream bis = new ByteArrayInputStream("abcd".getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int ch = 0;

        while ((ch = bis.read())!= -1){
            //将所有读取到bis的字节数据存到bos的内存字节数组中去
            bos.write(ch);
        }

        System.out.println(bos.toString());
    }
}
