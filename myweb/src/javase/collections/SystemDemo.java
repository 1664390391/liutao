package javase.collections;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * details:System类的常用方法演示
 *
 * @author lt
 * @date 2018/9/5
 */
public class SystemDemo {
    public static void main(String [] args){
//        getSystemProp();

//        runtimeDemo();

        mathDemo();

    }

    private static void mathDemo() {
        System.out.println(Math.PI);
        //返回大于参数的最小double数
        double d1 = Math.ceil(12.56);
        //返回小于参数的最大double数
        double d2 = Math.floor(12.56);
        //返回四舍五入的double数
        double d3 = Math.round(12.56);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        //随机输出0-9
        for(int i = 0;i< 10;i++){
            System.out.println((int)Math.floor(Math.random()*10));
        }

    }

    private static void runtimeDemo() {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取系统属性信息,并存储到了Properties集合中，其实就是hashtable子类，
     * 这集合没有泛型，因为里面存放的都是String类型，详细可查API
     * 取出方式最好使用自己的取出方式，而不选择迭代器。（因为没有泛型啊）
     *
     */
    private static void getSystemProp() {
        //得到当前时间, 返回以毫秒为单位的当前时间。
        long l1 = System.currentTimeMillis();
        //得到当前时间, 返回以毫秒为单位的当前时间。
        long l2 = System.nanoTime();
        //使用System的方法设置全局属性，其他程序也都可以使用
        System.setProperty("myprop111","myvalue111");
        //取出系统所有的键值对集合
        Properties props = System.getProperties();
        //使用Properties方法可以设置自己的自定义属性信息
        props.setProperty("myprop","myvalue");
        //取到所有键的Set
        Set<String> nameSet = props.stringPropertyNames();
        for (String s : nameSet) {
            System.out.println(s+":"+props.getProperty(s));
        }
    }
}
