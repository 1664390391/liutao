package javase.io.othercommonclass;

import java.io.*;
import java.util.*;

/**
 * details:序列流的简单使用
 *
 * @author lt
 * @date 2018/10/29
 */
public class SequenceInputStreamDemo {
    public static void main(String [] args) throws IOException {
        /*
//       测试多个输入流合并输出到一个文件上
        //SequenceInputStream(Enumeration<? extends InputStream> e)：该序列流参数是一个枚举集合，什么集合可以将数据返回成枚举类型呢？
        //首先想到的是效率不高的Vector，形参是输入流对象
        Vector<FileInputStream> vector = new Vector<>();
        //确定集合中输入流的元素
        vector.add(new FileInputStream("PrintDemo1.txt"));
        vector.add(new FileInputStream("PrintDemo2.txt"));
        //使用集合中的方法将数据返回成枚举类型
        Enumeration<FileInputStream> en =  vector.elements();
        */

        //如果想使用arraylist怎么办呢
        List<FileInputStream> list = new ArrayList<>();
        list.add(new FileInputStream("PrintDemo1.txt"));
        list.add(new FileInputStream("PrintDemo2.txt"));

        //如何使用list中的方法将数据封装成枚举类型呢？

        /*
        //首先建造一个枚举类型试试，发现需要实现hasMoreElements、nextElement两个方法，而list中并没有，但是list却有迭代器和这个相似

        //第二步，创建一个List的迭代器，将集合和枚举关联起来，为什么使用final修饰？因为it再被内部类进行访问，java8已经会自动将其转化为final了
        final  Iterator<FileInputStream> it = list.iterator();
        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return it.next();
            }
        };
        */
        //虽然原理如上述，但是集合工具类提供了相关的方法操作
        Enumeration<FileInputStream> en = Collections.enumeration(list);

        //上述的枚举数据封装好之后，将其放到序列流中
        SequenceInputStream sis = new SequenceInputStream(en);
        //将数据写入一个目的地
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("SequenceInputStreamDemo.txt"));
        int ch ;
        while((ch = sis.read())!=-1){
            out.write(ch);
        }
        out.close();
        sis.close();

    }
}
