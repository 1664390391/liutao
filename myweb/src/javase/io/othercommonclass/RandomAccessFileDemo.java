package javase.io.othercommonclass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * details:RandomAccessFile类的简单使用：随机访问文件流
 *
 * @author lt
 * @date 2018/10/30
 */
public class RandomAccessFileDemo {
    public static void main(String [] args) throws IOException {
//        testRandomAccessFileWrite();
//        testRandomAccessFileRead();
        testRandomWrite();
    }

    /**
     * 测试随机写（其实所谓的随机就是指定位置）
     由此可以联想，如果想要多线程操作一个文本文件实现同时写入又不覆盖怎么办呢？使用随机访问文件流，每个线程指定位置
     例如线程1负责 0 ~ 99 字节数据的填写， 线程2 负责 100 ~199 字节数据的填写。以此类推，每个线程写满就停止工作，岂不美哉！
     */
    private static void testRandomWrite() throws IOException{
        //之前在testRandomAccessFileWrite已经将前20个字节的数据写入，这边想在继续写，又不想覆盖，怎么办呢？指定位置即可搞定！
        RandomAccessFile raf = new RandomAccessFile("testRandomAccessFile.txt","rw");
        //指定位置进行写入
        raf.seek(3*10);
        raf.write("张三".getBytes());
        raf.writeInt(102);
        raf.close();

    }

    /**
     * 测试RandomAccessFile类的读取
     *
     *
     */
    private static void testRandomAccessFileRead() throws IOException {
        //创建随机访问文件流，设置为只读模式
        RandomAccessFile raf = new RandomAccessFile("testRandomAccessFile.txt","r");

        //因为内部是字节数组型存储，所以可以使用seek()指定位置,为什么这里是10的倍数？因为本机的编码是utf-8，一个中文三个字节，名称+一个int数 = 10个字节
        raf.seek(1*10);

        //如果正常的读取
        byte [] buf = new byte[6];
        raf.read(buf);//读取文件中的数据，并存满一个缓冲区
        String name = new String(buf);

        //使用readInt读取一个四个字节的int数
        int age = raf.readInt();
        System.out.println("name="+name+",age="+age);
        //得到当前指针的位置
        System.out.println("pos="+raf.getFilePointer());
        raf.close();

    }

    /**
     * 测试RandomAccessFile类的写入
     * 构造函数：第一个形参是确定文件的位置，第二个形参是确定操作方式，
     一共只有四种操作方式：
     * “r”:只读
     * “rw”:读写，文件不存在则尝试创建该文件，文件存在则不创建
     * “rws”
     * “rwd”
     */
    private static void testRandomAccessFileWrite() throws IOException {
        //文件不存在则尝试创建该文件，文件存在则不创建
        RandomAccessFile raf = new RandomAccessFile("testRandomAccessFile.txt","rw");
        raf.write("小强".getBytes());
        //write是直接写最低8位字节，也就是wirte(byte)，使用writeInt是4个字节都写
        raf.writeInt(97);  //这里是四个字节   0000-0000 0000-0000 0000-0000 0110-0001
        raf.write("旺财".getBytes());
        raf.writeInt(99);
        //记得只要是操作流的，都要关闭
        raf.close();
    }
}
