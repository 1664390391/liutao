package javase.faceobject;

/**
 * Created by 16643 on 2018/8/22.
 */
interface inter{
    void inter();
}

class c1 implements  inter{
    private int i = 0;
    @Override
    public void inter() {
        i++;
        System.out.println(i);
    }
}

class MyInner{
    public void  inner(){
        System.out.println("aaa");
    }
    static void f(MyInner mi){
        mi.inner();
    }
}

class c2 extends MyInner{
    private int i = 0;
    public void  inner(){
        super.inner();
        i++;
        System.out.println(i);
    }

    private class innerClass implements inter{

        @Override
        public void inter() {
            c2.this.inner();
        }
    }

    inter get(){
        return new innerClass();
    }
}

class cc {
    private inter in;
    cc(inter in){
        this.in = in;
    }
    void go(){
        in.inter();
    }
}


public class InnerClassDemo2 {
    public static void main(String [] args){
        c1 ccc1 = new c1();
        c2 ccc2 = new c2();
        MyInner.f(ccc2);
        cc cc1 = new cc(ccc1);
        cc cc2 = new cc(ccc2.get());
        cc1.go();
        cc1.go();
        cc2.go();
        cc2.go();
    }
}
