package javase.collections;

import java.util.*;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/3
 */


/*
class Outer{
    static class Inner1{
       static void show(){}

    }
    class Inner2{
         void show(){}
    }
}
*/


public class MapDemo {
    public static void main(String [] args){
        //测试静态类
//        Outer.Inner1.show();
//        Outer.Inner2 inner2 = new Outer().new Inner2();
//        inner2.show();

//        test1();
        Map<Integer,String> map = new HashMap<>();
        for(int i = 0;i< 10000000;i+=2){
            map.put(i,"a");
        }
        keysetEfficiency(map);
        entrysetEfficiency(map);
        entrysetEfficiency_1(map);
        valueEfficiency(map);
    }

    private static void entrysetEfficiency_1(Map<Integer, String> map) {
        long startTime1 =System.currentTimeMillis();
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            Integer key = entry.getKey();
            String value = entry.getValue();
        }
        long endTime1 =System.currentTimeMillis();
        System.out.println("直接获取Map.Entry对象得到的运行时间："+(endTime1-startTime1)+"ms");
    }

    private static void valueEfficiency(Map<Integer, String> map) {
        long startTime1 =System.currentTimeMillis();
        Collection<String> collection = map.values();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()){
            String value = it.next();
        }
        long endTime1 =System.currentTimeMillis();
        System.out.println("通过values()得到的运行时间："+(endTime1-startTime1)+"ms");
    }

    private static void entrysetEfficiency(Map<Integer, String> map) {
        long startTime1 =System.currentTimeMillis();
        //得到一个个的键值对（Map.Entry对象）。使用set集合存储
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
        while (it.hasNext()){
            //迭代器取得每个Map.Entry对象,在使用get()获取信息
            Map.Entry<Integer,String> me = it.next();
            Integer key = me.getKey();
            String value = me.getValue();
        }
        long endTime1 =System.currentTimeMillis();
        System.out.println("通过entryset()得到的运行时间："+(endTime1-startTime1)+"ms");
    }

    private static void keysetEfficiency(Map<Integer,String> map) {
        long startTime1 =System.currentTimeMillis();
        //通过keyset取到所有的键，然后在进行输出
        Set<Integer> keyset = map.keySet();
        //将取得的set集合使用迭代器遍历并取得所有的值，然后遍历
        Iterator<Integer> it =  keyset.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            String value = map.get(i);
        }
        System.out.println();
        long endTime1 =System.currentTimeMillis();
        System.out.println("通过keyset取到所有的键运行时间："+(endTime1-startTime1)+"ms");

    }

    private static void test1() {
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


