package springstudy.myspring.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 16643 on 2018/7/21.
 */
public class TestMap {
    public static void main(String [] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aaa");
        map.put(2,"rfrr");
        map.put(3,"sss");
        for (Map.Entry<Integer, String> entry:map.entrySet()){
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

    }
}
