package javase.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by 16643 on 2018/10/16.
 */
class Fruit{}

class Apple extends Fruit{}

class LittleApple extends Apple{}

public class WildcardCharacterTest {
    public static void main(String [] args){
        test();
    }

    public static  void test(){
        TreeMap<Integer,String> sortedMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            sortedMap.put(i,"map"+i);
        }
        System.out.println(sortedMap);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        int low = 0,high = 0;
        for(int i = 0;i<= 6;i++){
            System.out.print("第"+i+"次执行");
            if(i == 3 ){
                low = it.next();
                System.out.print("low");
            }
            if(i == 6){
                high = it.next();
                System.out.print("high");
            }
            else
                System.out.println("it.next()="+it.next());
        }
        System.out.println(low);
        System.out.println(high);
    }

    //测试通配符的下
    static void writeTo(){
        List<? super Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new LittleApple());
//        apples.add(new Fruit());

    }
}
