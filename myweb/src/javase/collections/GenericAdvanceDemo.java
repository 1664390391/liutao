package javase.collections;

import javase.collections.bean.Person;
import javase.collections.bean.Student;
import javase.collections.bean.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * details:测试通配符
 *
 * @author lt
 * @date 2018/9/3
 */
public class GenericAdvanceDemo {
    public static void main(String [] args){
        List<Student> list = new ArrayList<>();
        list.add(new Student("s1",11));
        list.add(new Student("s2",22));

        List<Worker> list2 = new ArrayList<>();
        list2.add(new Worker("w1",51));
        list2.add(new Worker("w2",52));

        printCollWithUpperLimit(list);
        printCollWithUpperLimit(list2);

    }


    /**
     * 测试通配符  ？  的使用
     * 如果需要返回一些东西或者对泛型内容进行其他取出并操作的时候，可以使用泛型T
     * public static <T>  T test(){...}
     * 如果只需要取得一些东西并进行简单的操作的时候，直接使用？通配符即可
     * 其实这里的 ? 就是 ？ extends Object
     *
     */
    public static void printColl(Collection<?> c){
       Iterator<?> it =  c.iterator();
       while (it.hasNext()){
           System.out.println(it.next());
       }
    }

    /**
     * 泛型的限定，如果只想打印person以及他的子类，在通配符中应该如何限定呢？
     * 使用 ？ extends Xxx    确定通配符的上限
     */
    public static void printCollWithUpperLimit(Collection<? extends Person> c){
        Iterator<? extends Person> it =  c.iterator();
        while (it.hasNext()){
            //这里可以使用多态的原理
            Person p = it.next();
            System.out.println(p.getName()+"xxxx");
        }
    }








}




