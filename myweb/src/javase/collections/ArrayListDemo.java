package javase.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * details:
 *
 * @author lt
 * @date 2018/8/31
 */
public class ArrayListDemo {
    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("aa");
        for (String s : list) {
            System.out.println("s:"+s);
        }

        System.out.println(list);
        System.out.println(list.toString());
    }
}
