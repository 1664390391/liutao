package javase.collections;

import java.util.*;

/**
 * details:
 *
 * @author lt
 * @date 2018/8/31
 */
public class ArrayListDemo {
    public static void main(String [] args){
//        test1();
//        List<Fu> list = new ArrayList<>();
//        list.add(new Fu());
//        list.add(new Zi());
//        list.get(1).show();

//        List<Fu> list = Arrays.asList(new Zi1());
        listTime();
        setTime();
    }

    private static void setTime() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i<= 1000000;i++){
            set.add(i);
        }
        long startTime = System.nanoTime(); // 获取开始时间
        set.contains(500000);
        long endTime = System.nanoTime(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static void listTime() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<= 1000000;i++){
            list.add(i);
        }
        long startTime = System.nanoTime(); // 获取开始时间
        list.get(500000);
        long endTime = System.nanoTime(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static void test1() {
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

class Fu {
    void  show(){
        System.out.println("fu show");
    }
}

class Zi extends Fu{
    void show2(){
        System.out.println("zi show");
    }
}

class Zi1 extends Zi{
    void show3(){
        System.out.println("zi1 show");
    }
}
