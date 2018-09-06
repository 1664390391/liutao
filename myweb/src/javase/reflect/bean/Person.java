package javase.reflect.bean;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/6
 */
public class Person {
    private  String name;
    private  int age;
    public String haha;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(" Person(String name, int age) run"+"name="+name+"age="+age);
    }

    public Person() {
        System.out.println(" Person() run");
    }

    public void show(){
        System.out.println("show() run+"+"name="+name+"age="+age);
    }
    public void showByParams(String name,int age){
        System.out.println("sshow1 run+"+"myname="+name+"myage="+age);
    }

    public static void staticMethod(){
        System.out.println("staticMethod() run");
    }

}
