package javase.io;

import java.io.*;

/**
 * details:测试简单的字节流的使用方式，其实和之前学习的字符流的使用方式都一样
 *
 * @author lt
 * @date 2018/10/19
 */
public class ByteStreamDemo {
    public static void main(String [] args) throws IOException {
//        OutputStreamDemo();
//        InputStreamDemo();
        testCopyByStream();

    }

    /**
     * 使用流复制文件，一个图片，这下不能使用字符流操作了，因为这是字节信息
     * 常用方法：
     * 1、自定义缓冲区 byte [] buf = new byte[1024]，然后reader(buf)
     * 2、使用缓冲区对象BufferedInputStream、BufferedOutputStream 然后用缓冲区对象的read()读取缓冲区数组中的一个一个字节进行不断的读写
     * 3、也可以使用缓冲区对象的同时，在加上自定义的数组，但是我觉得有点浪费，缓冲区已经默认数组了，自己还重新创建了
     */
    private static void testCopyByStream() throws IOException {
        //创建输入，输出字节流，并使用缓冲区技术
        FileInputStream fis = new FileInputStream("D:\\liutao\\壁纸\\玉漱白冰\\玉漱8.png");
        FileOutputStream fos = new FileOutputStream("D:\\liutao\\壁纸\\玉漱白冰\\玉漱8_copy.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fos);

        //不断循环的读写
        int len;
        while ((len = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(len);
            //字节流的刷新没有用，但是其对应的缓冲区的刷新方法是有用的，最好每次写的时候都刷新一遍
            bufferedOutputStream.flush();
        }

        bufferedInputStream.close();
        bufferedOutputStream.close();


    }

    /**
     * 测试简单的字节输入流（读取到内存）
     */
    private static void InputStreamDemo() throws IOException {
        FileInputStream fis = new FileInputStream("testFileOutputStream.txt");
        System.out.println("该文件的长度为："+fis.available()+"个字节");
        byte [] buf = new byte[3];
        int len ;
        while ((len = fis.read(buf)) != -1){
            System.out.println(new String(buf,0,len));
        }
        fis.close();
    }

    /**
     * 测试简单的字节输出流
     *  注意：没有进行异常处理
     */
    private static void OutputStreamDemo() throws IOException {
        //1、创建一个字节输出流，然后关联上需要写入的目的地
        FileOutputStream fos = new FileOutputStream("testFileOutputStream.txt");
        //2、写数据，直通过字节流接写入到目的地中，不存在字符流写完需要刷新的问题
        fos.write("abcdefg".getBytes());
        //3、直接关闭资源，不需要刷新
        fos.close();
    }
}
