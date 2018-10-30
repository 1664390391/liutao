package javase.io.othercommonclass;

import java.io.*;

/**
 * details:数据操作流的相关操作
 *  基本常用的方法writeInt、readInt、writeLong、readLong....不提了
 *  writeUTF和readUTF ： 这对方法需要注意。用的是utf-8修改版的字符集，所以转换流指定解码方式是不可读的，这里只能成对出现。
 *
 * @author lt
 * @date 2018/10/30
 */
public class DataStreamDemo {
    public static void main(String [] args) throws IOException {
//        DataStreamWrite();
        //使用writeUTF的特殊utf-8编码进行书写,所以只能用对应的方法读取了
        DataStreamRead();
    }

    /**
     *  数据流的测试ReadUTF，和writeUTF成对出现的
     */
    private static void DataStreamRead() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("DataStream.txt"));
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();

    }

    /**
     * 数据流的测试writeUTF
     */
    private static void DataStreamWrite() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("DataStream.txt"));
        //utf-8修改版的编码进行操作 z： 你好
        dos.writeUTF("你好");
        dos.close();

    }
}
