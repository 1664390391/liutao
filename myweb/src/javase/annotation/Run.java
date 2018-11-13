package javase.annotation;

/**
 * 测试需要运行的方法，加上mytest的注解
 */
public class Run {
    @MyTest
    public void test1(){
        System.out.println("test1() run");
    }

//    @MyTest
    public void test2(){
        System.out.println("test1() run");
    }
}
