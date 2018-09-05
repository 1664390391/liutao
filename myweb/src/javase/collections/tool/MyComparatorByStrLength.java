package javase.collections.tool;

import javase.collections.bean.Person;

import java.util.Comparator;

/**
 * details:我的自定义比较器
 * 长度由小到大
 *
 * @author lt
 * @date 2018/9/1
 */
public class MyComparatorByStrLength implements Comparator<String>{

    /**
     * o1长度大，则返回正数，表示o1 > o2
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(String o1, String o2) {
        int temp = o1.length() - o2.length();
        return temp == 0 ? o1.compareTo(o2) : temp;
    }
}
