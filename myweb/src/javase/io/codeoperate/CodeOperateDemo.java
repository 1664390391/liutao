package javase.io.codeoperate;

import java.io.UnsupportedEncodingException;

/**
 * details:简单的编解码操作
 *
 * @author lt
 * @date 2018/10/30
 */
public class CodeOperateDemo {
    public static void main(String [] args) throws UnsupportedEncodingException {
        /**
         * 字符串 --> 字节数组  ： 编码（将看得懂的编成了看不懂的）
         * 字节数组 --> 字符串  ： 解码（将看不懂的解释成看懂的）
         * 使用String对象即可完成这些操作
         */
        byte [] defalutBuf = "你好".getBytes();  //-28 -67 -96 -27 -91 -67
        byte [] GBKBuf = "你好".getBytes("gbk"); //-60 -29 -70 -61
        byte [] UTFBuf = "你好".getBytes("utf-8"); //-28 -67 -96 -27 -91 -67
        //由上述可以看出默认的编码方式是utf-8

//        printBuf(defalutBuf);
//        System.out.println();
//        printBuf(GBKBuf);
//        System.out.println();
//        printBuf(UTFBuf);

        //解码，将字节数组变成字符串
        String defalutStr = new String(defalutBuf);//默认解码方式也是utf-8
        String gbkStr = new String(GBKBuf,"gbk");
        String utfStr = new String(UTFBuf,"utf-8");
        System.out.println(defalutStr);
        System.out.println(gbkStr);
        System.out.println(utfStr);

    }

    private static void printBuf(byte[] buf) {
        for(int i = 0;i< buf.length;i++){
            System.out.print(buf[i]+" ");
        }

    }
}
