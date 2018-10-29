package javase.io.othercommonclass.bean;

import java.io.Serializable;

/**
 * Created by 16643 on 2018/10/29.
 */
public class Person implements Serializable{
    private String name;
    private int age;
    //显示声明自定义的serialVersionUID
    static final long serialVersionUID = 12312421412L;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){}

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
                '}';
    }
}
