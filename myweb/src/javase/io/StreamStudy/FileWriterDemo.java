package javase.io.streamstudy;

import java.io.FileWriter;
import java.io.IOException;

/**
 * details:测试简单的字符输出流（写）
 *
 * @author lt
 * @date 2018/10/12
 */
public class FileWriterDemo {
    public static void main(String [] args)  {
        //测试字符输入流简单的使用+基本的异常处理
        testWriter();
    }

    private static void testWriter()  {
        /*
        1、声明一个字符输出流:FileWriter,以供下面创建对象和关闭资源的时候使用
        2、需要明确保存的位置（可以使用相对路径，也可以指定绝对的路径）
        3、若该位置文件不存在，则新建，否则则覆盖该名称的同名文件（先删除同名文件再创建）
        4、FileWriter(String fileName, boolean append),若append为true，那么可以实现当前文件实现续写（不删除，继续原来的文件续写，没有则新建）
         */
        FileWriter writer = null;
        //外层的异常处理：处理流工作中发生的问题
        try {
//            writer = new FileWriter("d:"+ File.separator+"liutaowork"+File.separator+"testWriter.txt");
            writer = new FileWriter("testWriter.txt");
             /*
            调用Writer中的writer(String) 将字符串写入
            注意：其实这里并没有保存数据，只是将字符串写入到临时缓冲区中（类似于记事本写完数据没有保存的状态，还没有写在实实在在的硬盘上）
             */
            writer.write("abc");
        } catch (IOException e) {
            //流工作中出现问题进行处理
            e.printStackTrace();
        }finally {
            //进行流关闭的时候，需要判断创建的输入流对象是否已经被实例化，否则就会产生NullPointerException，例如创建文件位置的时候发生失败
            if(writer != null){
                //里面的异常处理：系统关闭资源时发生的错误进行的异常处理，系统级错误程序员不可控制
                try {
                    // 将当前输出流的进行刷新,就像记事本中一次保存的操作
                    writer.flush();
                    //关闭当前的流，类似于关闭记事本（会进行一次流的刷新），后续不可以在进行其他操作
                    writer.close();
                } catch (IOException e) {
                    //这块的错误，我们程序员处理不了，底层的错误只能由一些底层的处理方式
                    new RuntimeException("底层关闭流出错！");
                    e.printStackTrace();
                }
            }
        }
    }
}
