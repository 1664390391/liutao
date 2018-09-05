package javase.collections;

import javase.collections.tool.MyComparatorByStrLength;
import sun.java2d.pipe.AAShapePipe;

import java.util.*;

/**
 * details:测试集合框架工具类
 *
 * @author lt
 * @date 2018/9/5
 */
public class CollectionsTools {
    public static void main(String [] args){
//        testSortAndSwapAndBinarySearchAndMax();
//        testReverseAndReplace();

//        ArraysToListDemo();

//        ListToArrayDemo();
        foreachTest();
    }

    /**
     * 可变参数列表必须在结尾
     * @param s
     * @param arr
     */
    private static void unknownParams(String s,int ... arr){

    }

    private static void foreachTest() {
        List<String> list = new ArrayList<>();
        for(int i = 0;i< 10000000;i++){
            list.add(String.valueOf(new Random()));
        }
        long startTime1 =System.currentTimeMillis();
        for (String s : list) {
            String temp = s;
        }
        long endTime1 =System.currentTimeMillis();
        System.out.println("foreach遍历时间："+(endTime1-startTime1)+"ms");
        long startTime2 =System.currentTimeMillis();
        for(int i = 0;i< list.size();i++){
            String temp = list.get(i);
        }
        long endTime2 =System.currentTimeMillis();
        System.out.println("普通for，每次判断list.size()："+(endTime2-startTime2)+"ms");
        long startTime3 =System.currentTimeMillis();
        int size = list.size();
        for(int i = 0;i< size;i++){
            String temp = list.get(i);
        }
        long endTime3 =System.currentTimeMillis();
        System.out.println("普通for，事先定义好size："+(endTime3-startTime3)+"ms");
    }

    private static void ListToArrayDemo() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ccc");
        list.add("bbbb");
        String [] arr = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(arr));
    }

    private static void ArraysToListDemo() {
        int [] arr = {1,3,2,5,8,3,1};
        List<int []> list = Arrays.asList(arr);
        System.out.println(list);
        System.out.println(list.get(0));

        String [] str = {"aa","cc","bb"};
        List list1 = Arrays.asList(str);
        System.out.println(list1);
    }

    /**
     * 测试集合的逆转和替换
     */
    private static void testReverseAndReplace() {
        //实现逆序的几种方式
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ccc");
        list.add("bbbb");
        System.out.println(list);
        //1、返回Collections.reverseOrder()一个比较器，逆转了实现comparable接口对象的集合的自然排序
//        Collections.sort(list, Collections.reverseOrder());
        //2、但是如果集合排序的时候有自定义比较器了怎么办呢？这里强行将长度从小到大排序逆转成从长到短
        Collections.sort(list,Collections.reverseOrder(new MyComparatorByStrLength()));
        System.out.println(list);
        //3、直接reverse，list的特有方式
        Collections.reverse(list);
        System.out.println(list);

        //替换，list的特有方式
        //实现原理就是 set (index , new)
        //int index = list.indexOf(old)
        Collections.replaceAll(list,"aa","aaa");


    }

    /**
     *   public static <T extends Comparable<? super T>> void sort(List<T> list)
     *   首先，不知道比较的是什么类型，就需要使用泛型，泛型怎么使用呢？使用？或者T！如果？代表所有的对象可以吗？不可以！
     *   因为比较的对象必须具备比较性，具备比较性必须实现Comparable 接口，使其具备比较性，或者传入一个比较器。用于自定义的排序。
     *   那么这里的泛型就是 T extends Comparable , 这时Comparable接口也有泛型，这里为了提升扩展性，可以接受泛型类以及其父类等所有的类型
     *   简而言之就是：需要传入一个具备比较性类型的集合才能够排序，这个类型可能不是该类自己实现comparable进行实现比较性的，
     *   只要他的父类有实现comparable接口并具备比较性即可。
     */
    private static void testSortAndSwapAndBinarySearchAndMax() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("ccc");
        list.add("bbbb");
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        //使用二分查找得到元素的位置
        //得到 -2 ： 负数表示没有该数据，2表示元素如果有应该放在第1（由2-1得到）个角标的位置上，因为有0角标的存在，
        int index = Collections.binarySearch(list,"ab");
        System.out.println("index="+index);
        // 得到最大值，没啥说的
        String max = Collections.max(list);
        System.out.println("max="+max);
        Collections.sort(list,new MyComparatorByStrLength());
        System.out.println(list);
//        Collections.swap(list,1,2);
//        System.out.println(list);
    }

}
