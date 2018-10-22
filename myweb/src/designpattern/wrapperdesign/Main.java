package designpattern.wrapperdesign;

/**
 * details:测试装饰设计模式的简单使用
 * 装饰设计模式：对一组对象进行功能增强时，可以使用该模式进行问题的解决。
    1、装饰比继承要灵活
    2、装饰类和被装饰类都必须所属同一个接口或者父类。（这句暂时没有完全理解这句话的用意，但是确实是其特点之一）
 *
 * @author lt
 * @date 2018/10/19
 */
public class Main {
    public static void main(String [] args){
        //原始Person的基本方法使用
        Person p = new Person();
        p.eat();
        System.out.println("---------启用增强person------");
        WrapperPerson wp = new WrapperPerson(p);
        wp.eat();
    }
}
