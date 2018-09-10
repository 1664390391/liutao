package springstudy.myspring.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.myspring.beanlife.BeanDemo;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/factory/beans.xml");
        Car car1 = (Car) ac.getBean("car1");
        System.out.println(car1);
        Car car2 = (Car) ac.getBean("car2");
        System.out.println(car2);

    }
}
