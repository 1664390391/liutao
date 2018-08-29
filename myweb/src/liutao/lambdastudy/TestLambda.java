package liutao.lambdastudy;

import java.util.*;

/**
 * Created by ym on 2018/7/27.
 * Function :
 * Params :
 * Return :
 */
public class TestLambda {


    static List<User> userList = Arrays.asList(
            new User("张三",20,2000),
            new User("李四",18,1000),
            new User("王五",10,300)
    );

    public static void main(String [] args){


        /**
         * 需求，获得指定条件的user对象
         */
//        List<User> list = filterUsers(userList);
//        for (User user : list) {
//            System.out.println(user.toString());
//        }

        /**
         * 优化方式1：使用策略设计模式，完成比较
         * 什么是策略设计模式？
         *  给定实现相同的接口的不同策略，即可按照不同策略进行不同的处理
         * 对userList集合按照我的接口myInter这个方式进行比较,传入我的接口的实现类
         * 这个时候如果再想按工资过滤，那么就需要修改实现接口的其他类，传入方法中即可。
         */
//        List<User> list = filterUsers2(userList,new FilterUserByAge());
//        for (User user : list) {
//            System.out.println(user.toString());
//        }
//        System.out.println("------------------------");
//
//        List<User> list2 = filterUsers2(userList,new FilterUserBySalary());
//        for (User user : list2) {
//            System.out.println(user.toString());
//        }

        /**
         * 优化方式二：使用匿名内部类
         */
//        filterUser3();

        /**
         * 优化方式三，使用lambda表达式
         */
//        filterUser4();

        /**
         * 优化方式四：假设除了数据什么都没有，那么有一个目前我没看懂的方式QAQ
         */
        filterUser5();

    }

    /**
     * 入门：老方法进行两个数字的比较
     */

    public static void test1(){
        //使用匿名内部类的表示
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        //初始一个treeset，传入一个比较器
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }


    public static void test2(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        //初始一个treeset，传入一个比较器
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }


    //需求：获取大于15岁的人
    public static List<User> filterUsers(List<User> userList){
        List<User> list = new ArrayList<>();

        //循环遍历传进来的值，取出大于15岁的，保存并返回
        for (User user : userList) {
            if(user.getAge() > 15){
                list.add(user);
            }
        }

        return list;
    }

    //需求：如果还想要工资大于500的呢？是不是需要重新copy上面的方法只改动一个if判断呢？所以使用第二种方式：设计模式，详情见myInter。。。

    /**
     * 优化方式1：使用设计模式，完成比较
     * 对userList集合按照我的接口myInter这个方式进行比较
     */
    public static List<User> filterUsers2(List<User> userList,myInter<User> inter){
        List<User> list = new ArrayList<>();

        //循环遍历传进来的值，取出大于15岁的，保存并返回
        for (User user : userList) {
            if(inter.test(user)){
                list.add(user);
            }
        }

        return list;
    }

    /**
     * 优化方式二：使用匿名内部类,实现接口的的同时定义接口的实现方法，不需要再单独写策略模式的实现类了
     */

    public static void filterUser3(){
        List<User> list = filterUsers2(userList, new myInter<User>() {
            @Override
            public boolean test(User user) {
                return user.getAge()>15;
            }
        });
        for (User user : list) {
            System.out.println(user.toString());
       }

    }

    /**
     * 优化方式三，使用lambda表达式
     */
    public static void filterUser4(){
        List<User> list = filterUsers2(userList,(u) -> u.getAge()>15);
        list.forEach(System.out::println);
    }

    /**
     * 优化方式四：假设除了数据什么都没有，那么有一个目前我没看懂的方式QAQ,StreamAPI
     */
    public static void filterUser5(){
        userList.stream()
                .filter((u) -> u.getAge()>15)
                .forEach(System.out::println);
    }

}
