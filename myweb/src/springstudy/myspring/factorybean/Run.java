package springstudy.myspring.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/factorybean/beans.xml");
        Car car = (Car) ac.getBean("car");
        System.out.println(car);

    }
}
