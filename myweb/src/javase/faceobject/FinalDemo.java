package javase.faceobject;

import java.util.Random;

/**
 * 测试final关键字
 * Created by 16643 on 2018/9/10.
 */
public class FinalDemo {
    public static void main(String [] args){
        System.out.println(FinalTest.NUM);
        //NUM是编译时期常量，直接类名就可以调用，不需要初始化该类
        //但是如果仅仅只是将一个域设置为static final的，那么并不足以确保该行为，因为它不是一个编译时期的常量，例如这里的NUM2
        //这时候访问就需要对该类进行类初始化。
        System.out.println(FinalTest.NUM2);
    }
}

class FinalTest extends FinalFu{
    static final int NUM = 4;
    static final int NUM2 = new Random().nextInt();
    static {System.out.println("static { run");}
}
class FinalFu{
    static {System.out.println("FinalFu static { run");}
}
