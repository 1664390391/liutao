package javase.collections;

import javase.collections.bean.Person;
import javase.collections.tool.MyComparatorByName;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * details:测试treeset的基本特性和比较器
 *
 * @author lt
 * @date 2018/9/1
 */
public class TreeSetDemo {
    public static void main(String [] args){
        //定义一个存放Person实体类的set,如果构造中加了自定义的比较器，那么优先比较自定义的比较方法
        TreeSet<Person> ts = new TreeSet<>(new MyComparatorByName());
        ts.add(new Person("a3",23));
        ts.add(new Person("a9",20));
        ts.add(new Person("a6",21));
        ts.add(new Person("a5",25));
        Iterator<Person> it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }

    }
}
