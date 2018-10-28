package javase.io.properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/**
 * details:演示Properties类的基本使用
 *
 * @author lt
 * @date 2018/10/25
 */
public class PropertiesDemo {
    public static void main(String [] args) throws IOException {
        //测试基本的存取
//        baseSaveAndGet();
        //测试list()的使用
//        testList();
        //将属性文件信息保存到配置文件中
//        storeToFile();
        //将配置文件中的信息读取出来
//        loadFile();
        //将配置文件中的信息读取出来，修改读取出来的信息在保存
        loadAndUpdateFile();
    }

    /**
     * 测试将配置文件中的信息读取出来，修改读取出来的信息在保存
     */
    private static void loadAndUpdateFile() throws IOException {
        //使用文件对象读取配置文件，如果配置文件不存在则创建一个新的，保证Properties集合加载的时候一定的正常的
        File file = new File("testSystemProp.properties");
        if(!file.exists()){
            file.createNewFile();
        }
        //读取配置文件中的信息，键值对的形式保存到Properties集合中
        FileInputStream fis = new FileInputStream(file);
        Properties properties =  new Properties();
        properties.load(fis);
        System.out.println("修改前。。。。");
        properties.list(System.out);
        //修改一些数据,因为数据是键值对的形式保存的，那么只要使用将同一个键的值覆盖掉即可
        properties.setProperty("3","newwangwu");
        System.out.println("修改后。。。。");
        properties.list(System.out);
        //将Properties集合保存到文件中，使用store()
        properties.store(new FileOutputStream(file),"test update");
        fis.close();
    }

    /**
     * 测试将配置文件中的信息读取出来
     * 方法：使用Properties集合类中的load方法，将配置文件中的有效的键值对信息读取到流中
     * 原理：使用流将每一行的数据读取，然后去除#开头的注释信息，然后将  =  关联的键值对信息保存到Properties集合中
     */
    private static void loadFile() throws IOException {
        //指定一些属性集合， 保存到Properties集合中
        Properties properties =  new Properties();
        properties.load(new FileInputStream("testSystemProp.properties"));
        properties.list(System.out);
    }

    /**
     * 测试使用Properties的store()将目前集合中所有的属性信息持久化到硬盘上
     */
    private static void storeToFile() throws IOException {
        //指定一些属性集合， 保存到Properties流中
        Properties properties =  new Properties();
        properties.setProperty("2","lisi");
        properties.setProperty("1","zhangsan");
        properties.setProperty("3","wuwu");
        //输出流，确定持久化的文件位置
        FileOutputStream fos = new FileOutputStream("testSystemProp.properties");
        //文件的注释信息，因为使用的是ISO 8859-1 字符编码写入该流，存中文就会转成相关进制数据
        String comments = "test my computer system prop";
        properties.store(fos,comments);
        //关流不要忘记，除了System.in/out 这些系统流，其他的都要关闭
        fos.close();
    }

    /**
     * 测试list方法的基本使用
     * list:将集合的属性列表输出到指定的输出流，此方法一般调试使用
     */
    private static void testList() {
        //例如测试系统属性集合， 然后输出到输出流
        Properties properties = System.getProperties();
        properties.list(System.out);
    }

    /**
     * 测试基本的存取
     * 注意：该集合中的键和值都是字符串类型。
     */
    private static void baseSaveAndGet() {
        Properties properties = new Properties();
        properties.setProperty("2","李四");
        properties.setProperty("1","张三");
        properties.setProperty("3","wuwu");
        //得到所有键的set集合
        Set<String> names = properties.stringPropertyNames();
        for (String name : names) {
            System.out.println(name+":"+properties.getProperty(name));
        }
    }
}
