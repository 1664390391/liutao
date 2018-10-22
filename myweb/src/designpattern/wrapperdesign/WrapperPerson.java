package designpattern.wrapperdesign;

/**
 * details:对原来的基本类（这里的Person）进行装饰，在不修改原来的代码的情况下增强功能
 *
 * @author lt
 * @date 2018/10/19
 */
public class WrapperPerson extends Person {
    //需要对原来的类增强，那么构造时候需要传入原来的类，并创建对象
    private Person p;

    public WrapperPerson(Person p) {
        this.p = p;
    }

    /**
     * 方法一：增强原始的person的基础功能
     */
    public void eat(){
        System.out.println("开胃酒");
        p.eat();
        System.out.println("饭后甜点");
    }

    /**
     * 其他方法：进行一些自定义的增强方法等等。。。用来丰富Person
     */
}
