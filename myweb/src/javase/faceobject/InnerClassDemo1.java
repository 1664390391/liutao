package javase.faceobject;

/**
 * Created by 16643 on 2018/8/22.
 */
interface D{
    String function();
}

class A {
    public void functionA(){

    }
}

class B {
    public void functionB(){

    }
}

public class InnerClassDemo1 {

    public D myd(String s){
        return new D() {
            private String instr;
            {
                instr = s;
                System.out.println("实例初始化。相当于构造器初始化匿名内部类");
            }
            @Override
            public String function() {
                System.out.println("函数调用+"+instr);
                return instr;
            }
        };
    }

    public static void main(String [] args){
//        new InnerClassDemo().myd("么么哒").function();
        System.out.println(args[0]);
    }
}
