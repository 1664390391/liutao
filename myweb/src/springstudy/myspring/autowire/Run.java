package springstudy.myspring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/autowire/beans.xml");
        Master m = (Master) ac.getBean("master");
        System.out.println("master="+m.getName());
        System.out.println("dog="+m.getDog().getName()+"dogage="+m.getDog().getAge());
    }
}
