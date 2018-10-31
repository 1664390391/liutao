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
        //简单的编码解码操作
//        encodingDemo();
        String str = "你好";
        byte [] orginalBuf = str.getBytes();
        //编码成功，解码使用的码表不对应，有可能救！有救的情况！怎么解决？
        //没救的情况就是得到的原始字节在解码的码表没有对应的数据，那么会使用未知符号等代替，再次使用该码表编码就没法得到原来的字节数据了，从而无法恢复
        //模拟服务器端解码的方式
         serverOperate(orginalBuf);
    }

    /**
     * 模拟服务器端解码的方式，例如tomcat的解码方式
     * @param orginalBuf 传递进来的一段编码之后的字节
     */
    private static void serverOperate(byte[] orginalBuf) throws UnsupportedEncodingException {
        //得到一段编码之后的字节，先使用tomcat默认编码表解码
        String s1 = new String(orginalBuf,"iso8859-1");
        System.out.println("得到默认解码之后的乱码字符"+s1);
        //2、再将乱码的字符使用相同的编码在编回去
        byte [] buf = s1.getBytes("iso8859-1");
        //3、找寻其他码表，进行解码
        String s2 = new String(buf,"utf-8");
        System.out.println("对应码表解码的数据："+s2);


    }

    /**
     * 字符串 --> 字节数组  ： 编码（将看得懂的编成了看不懂的）
     * 字节数组 --> 字符串  ： 解码（将看不懂的解释成看懂的）
     * 使用String对象即可完成这些操作
     */
    private static void encodingDemo() throws UnsupportedEncodingException {
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
