package javase.io.othercommonclass.bean;

import java.io.Serializable;

/**
 * Created by 16643 on 2018/10/29.
 */
public class Person implements Serializable{

    public Person(){
        System.out.println("实现Serializable接口的Person类的构造器。。。,hashcode="+hashCode());
    }

    private String name;
    private int age;
    /*
    不被序列化的字段
    字段一旦是静态的，那么随着类的加载而加载，并有初始化的默认值，
    这个时候对象进行操作的只是对象特有的一些属性字段 ，序列化对象也不会序列化这些字段。
    private static int age;
    非静态字段，又不想被序列化，使用该关键字进行修饰
    private transient int age;

     */

    //显示声明自定义的serialVersionUID
    static final long serialVersionUID = 12312421412L;

    public Person(String name, int age) {
        System.out.println("实现Serializable接口的Person类有参数的的构造器。。。,hashcode="+hashCode());
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'+"hashcode="+hashCode();
    }
}
