package javase.collections;

import java.util.*;

/**
 * details:
 *
 * @author lt
 * @date 2018/8/30
 */
public class CollectionDemo {
    public static void main(String [] args){
//        Collection<Object> coll = new ArrayList<>();
//        show(coll);
//        TestIterator();
        TestListIterator();
    }

    /**
     * 测试集合中的迭代器对象
     */
    private static void TestListIterator() {
        List<String> coll = new ArrayList<>();
        coll.add("a1");
        coll.add("a2");
        coll.add("a3");

        //两种取出方法。方便操作使用while这一种
        ListIterator it = coll.listIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        it.set("asaasassa");
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }


    }
    /**
     * 测试集合中的迭代器对象
     */
    private static void TestIterator() {
        Collection<Object> coll = new ArrayList<>();
        coll.add("a1");
        coll.add("a2");
        coll.add("a3");

        //两种取出方法。方便操作使用while这一种
        Iterator it = coll.iterator();
        while (it.hasNext()){

            System.out.println(it.next());

        }
        //移除由next产生的最后一个元素
        it.remove();
        System.out.println("- -- ---- -------------");
        //开发使用第二种。for循环，节省内存
        //初始化表达式，判断条件，循环体，循环后操作  -- > 这里将判断条件和循环后操作结合在一起了
        for (Iterator it1 = coll.iterator(); it1.hasNext(); ) {
            System.out.println(it1.next());
        }

    }

    private static void show(Collection<Object> coll) {
        coll.add("a1");
        coll.add("a2");
        coll.add("a3");
        System.out.println(coll);
        coll.remove("a");
        System.out.println(coll);

    }
}
