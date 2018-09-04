package javase.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/3
 */
public class MapDemo {
    public static void main(String [] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aaa");
        map.put(2,"fff");
        System.out.println(map.get(1).toString());
        System.out.println(map.size());
        String s = map.remove(1);
        System.out.println(s);
        System.out.println(map.size());

    }
}
