package javase.collections.tool;

import javase.collections.bean.Person;

import java.util.Comparator;

/**
 * details:我的自定义比较器
 *
 * @author lt
 * @date 2018/9/1
 */
public class MyComparatorByName implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp == 0 ? o1.getAge() - o2.getAge() : temp;
    }
}
