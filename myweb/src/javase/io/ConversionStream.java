package javase.io;

import java.io.*;

/**
 * details:测试转换流
 *
 * @author lt
 * @date 2018/10/22
 */
public class ConversionStream {
    public static void main(String [] args) throws IOException {
        //测试字节流转换成字符流
//        InputStreamReaderDemo();
        //测试字符流转换为字节流
//        OutputStreamWriterDemo();
        //代码综合
        comprehensiveStream();
    }

    /**
     * 将System.in 和 System.out 两个流转换的字节流再包装的缓冲区直接两步操作起来
     */
    private static void comprehensiveStream() throws IOException {
        //使用字符流的缓冲区关联键盘录入的系统输入流
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //使用缓冲区操作字符输出流，关联键盘输出
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
        //定义变量记录每次读取的一行数据
        String line = null;
        while ((line = bufr.readLine()) != null){
            if("over".equals(line))
                break;
            //使用转换来的字符流输出数据，替代了System.out.println
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }

    }

    /**
     * 输入流转换已经测试过，然后System.out.println已经out，操作字符输出流，底层关联字节流进行输出
     */
    private static void OutputStreamWriterDemo() throws IOException {
        //键盘输入的字节输入流对象
        InputStream in = System.in;
        //使用输入转换流将字节输入流转换成字符输入流
        InputStreamReader isr = new InputStreamReader(in);
        //使用字符流的缓冲区读取数据
        BufferedReader bufr = new BufferedReader(isr);
        //获得系统输出流对象
        OutputStream out = System.out;
        //使用字符流转换成字节流，关联字节流，然后操作字符流让其底层走字节流的操作
        OutputStreamWriter osw = new OutputStreamWriter(out);
        //使用缓冲区操作字符输出流
        BufferedWriter bufw = new BufferedWriter(osw);
        //定义变量记录每次读取的一行数据
        String line = null;
        while ((line = bufr.readLine()) != null){
            if("over".equals(line))
                break;
            //使用转换来的字符流输出数据，替代了System.out.println
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }

    }

    /**
     * 在KeyboradInputDemo里面有每次读取键盘输入的一行数据并展示的问题
     * 注意：支持中文的读取展示等。
     * 里面做了很多的判断，现在只需要将System.in对象转换成字符对象，然后使用缓冲区的readline()即可
     */
    private static void InputStreamReaderDemo() throws IOException {
        //键盘输入的字节输入流对象
        InputStream in = System.in;
        //使用输入转换流将字节输入流转换成字符输入流
        InputStreamReader isr = new InputStreamReader(in);
        //使用字符流的缓冲区读取数据
        BufferedReader bufr = new BufferedReader(isr);
        //定义变量记录每次读取的一行数据
        String line = null;
        while ((line = bufr.readLine()) != null){
            if("over".equals(line))
                break;
            System.out.println(line);
        }
    }
}
