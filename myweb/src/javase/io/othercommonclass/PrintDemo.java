package javase.io.othercommonclass;

import java.io.*;

/**
 * 测试打印流Print的一些操作
 * Created by 16643 on 2018/10/28.
 */
public class PrintDemo {
    public static void main(String [] args) throws IOException {

//        PrintStreamDemo();

//        PrintWriterDemo();

    }

    /**
     * PrintWriter类的简单测试
     * 项目中经常使用，例如在浏览器访问一个服务器的时候，服务器返回的数据就是使用PrintWriter将数据一行一行回写到浏览器上
     *
     */
    private static void PrintWriterDemo() throws IOException {

        //弄一个输出流缓冲区用于测试，一个转换流用于将系统的字节流转换为字符流，再用缓冲区进行包装
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //创建一个打印流，可以将数据打印到目的地，这里使用控制台测试,第二个构造参数加上true表示自动刷新
        PrintWriter out = new PrintWriter(System.out,true);

        String line;
        while ((line = bufr.readLine())!= null){
            if("over".equals(line))
                break;
            out.println(line);
        }
        out.close();
        bufr.close();
    }

    /**
      write(int b)：和FileOutputStream中的write一样，都是取最后的八位，进行ascii码表的对应处理。

      print(int i)：和write()不同，这个是将数字转成字符串，保持原样将数据打印到目的地
   */
    private static void PrintStreamDemo() throws IOException {
        //例如
//        FileOutputStream fos = new FileOutputStream("PrintDemo.txt");
//        //支取最后八位，写入ascii码表的值
//        fos.write(97); //a
//        fos.close();
        PrintStream ps = new PrintStream("PrintDemo1.txt");
        ps.write(97);
        ps.close();
        PrintStream ps1 = new PrintStream("PrintDemo2.txt");
        ps1.print(97);
        ps1.close();
        PrintStream ps2 = new PrintStream(new File("PrintDemo3.txt"));
        ps2.print(97);
        ps2.close();

    }
}
