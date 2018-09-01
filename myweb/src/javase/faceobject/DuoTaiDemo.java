package javase.faceobject;

import java.util.HashMap;

/**
 * details:多态基本知识练习
 *
 * @author lt
 * @date 2018/9/1
 */

interface Inter{
    void show();
}

public class DuoTaiDemo {
    public static void main(String [] args){
        //使用匿名内部类实现Inter接口中函数的调用
        //因为要创建接口的对象，必须实现其方法使其成为一个正常类才可以继续进行实例化，又由于这边使用接口 变量 接受实例化的对象，所以使用的是多态的原理。
        Inter in = new Inter() {
            @Override
            public void show() {
                System.out.println("duotai run");
            }
        };
        in.show();

        //使用匿名内部类实现Inter接口中函数的调用,这里没有使用到多态的原理，只是创建接口的一个匿名内部类然后实现方法并调用
        new Inter() {
            @Override
            public void show() {
                System.out.println("duotai22222 run");
            }
        }.show();


        new HashMap<String,String>(){
            {
                put("aa","aa");
            }
        };


        Demo d = new Demo();
        Demo d2 = new Demo();

    }
}

/**
 class Demo{
 static {  静态初始化代码块/类初始化代码块   }  ：每个类在加载的时候调用一次这块代码，类加载完毕之后就不会执行第二次了（所以不可以调用类中非静态方法）
 {   实例初始化代码块     }   每次创建对象都会调用一次这块代码，这里可以调用类中的非静态方法，因为是创建对象才执行的代码块。
 }
 */
class Demo{

    static class Inner{

    }

    static {
//        show();
        System.out.println("类初始化代码块");
    }

    {
        show();
        System.out.println(" 实例初始化代码块");
    }

    void show(){
        System.out.println("show run");
    }
}



class  Fu{
    int show (int a,int b){
        return 0;
    }
}


class Zi extends Fu{
    @Override
    public  int show(int a, int b){
        return 0;
    }


    private  int show(int a, long b){
        return 0;
    }

//    public  short show(int a, int b){
//        return 0;
//    }

    //不能覆盖父类非静态的方法
   /* static   int show(int a, int b){
        return 0;
    }*/


}








