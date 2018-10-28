package javase.io.othercommonclass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 测试打印流Print的一些操作
 * Created by 16643 on 2018/10/28.
 */
public class PrintDemo {
    public static void main(String [] args) throws IOException {

        PrintStreamDemo();

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

    }
}
