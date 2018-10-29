package javase.io.othercommonclass;

import javase.io.othercommonclass.bean.Person;

import java.io.*;

/**
 * 对象操作流的学习
 * Created by 16643 on 2018/10/29.
 */
public class ObjectStreamDemo {
    public static void main(String [] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStreamDemo();
        ObjectInputStreamDemo();
//        Person p = new Person("小强",10);
//        System.out.println(p.toString());
    }



    /**
     * 对象输出流的基本演示，将一个对象信息持久化到硬盘上
     *
     */
    private static void ObjectOutputStreamDemo() throws IOException {
        //1、我的功能是要干嘛的？将数据持久化到硬盘上！ok，那么是输出，确定是纯文本不？不确定。ok，使用FileOutputStream
        //默认规定：这里的功能是序列化对象数据的，对象数据不仅仅包含本身的一些字段属性，还有其他内容，所以默认使用object作为后缀
        FileOutputStream fos = new FileOutputStream("testObjectStream.object");
        //2、但是！仅仅使用FileOutputStream这个输出流并不能解决对象持久化的问题，所以需要额外功能，操作对象的功能！
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //3、将一个实现Serializable接口的对象进行输出
        oos.writeObject(new Person("小强",10));
        oos.writeObject(new Person("wangcai",20));
        oos.close();
    }

    /**
     * 将序列化的文件使用对象输入流读取到内存中来
     */
    private static void ObjectInputStreamDemo() throws IOException, ClassNotFoundException {
        //原理和ObjectOutputStream一样，确定流字节输入流，并且需要额外功能，读出对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testObjectStream.object"));
        Person p = null;
        //解释一下这里为什么会抛出ClassNotFoundException
        //进行反序列化需要两个要求，序列化的硬盘文件和原始的类，这里的readObject会抛出ClassNotFoundException
        while(( p = (Person) ois.readObject())!= null){
            System.out.println(p.toString());
        }
        ois.close();
    }
}
