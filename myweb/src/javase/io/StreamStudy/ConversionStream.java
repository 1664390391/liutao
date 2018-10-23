package javase.io.StreamStudy;

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
//        comprehensiveStream();
        //测试根据编码表进行文件的读写
//        writeTextByEncode();
        readTextByEncode();
    }

    /**
     * 根据writeTextByEncode所书写的文件，然后将其用指定的编码表进行解析
     */
    private static void readTextByEncode() throws IOException {
        char [] buf = new char[10];
        //使用默认的平台编码表进行解析，得到你好两个字
//        FileReader fr = new FileReader("defalut_encoding.txt");
//        int len = fr.read(buf);

        //将u8的文件使用gbk读，gbk一次只读两个字节，而你好在utf-8中每个中文字符占3个字节
        //所以得到6个字节的gbk解码文字：浣犲ソ
//        InputStreamReader isr = new InputStreamReader(new FileInputStream("appoint_encoding_u8.txt"),"gbk");
//        int len = isr.read(buf);

        //同理，使用u8编码解码gbk的文件，utf-8得到两个未知符号��
        InputStreamReader isr = new InputStreamReader(new FileInputStream("appoint_encoding_gbk.txt"),"utf-8");
        int len = isr.read(buf);

        String str = new String(buf,0,len);
        System.out.println(str);

    }

    /**
     * 测试根据编码表进行文件的读写
     * 如果使用默认的方法进行简单的读写，那么就使用FileWriter 对象，使用默认的系统编码表进行文件写入
     *
     */
    private static void writeTextByEncode() throws IOException {
//        FileWriter fw = new FileWriter("defalut_encoding.txt");//这里得到默认编码表所产生的文件，你好用了6个字节
//        fw.write("你好");
//        fw.close();

        //2、使用字节转换流指定编码表进行写入，这里是6个字节
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("appoint_encoding_u8.txt"),"utf-8");
//        osw.write("你好");
//        osw.close();

        //3、指定另一种码表,gbk是4个字节
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("appoint_encoding_gbk.txt"),"gbk");
        osw.write("你好");
        osw.close();

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
