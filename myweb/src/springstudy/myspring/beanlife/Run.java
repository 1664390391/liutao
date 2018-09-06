package springstudy.myspring.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/beanlife/beans.xml");
//        BeanDemo beanDemo = (BeanDemo) ac.getBean("beanDemo");
//        beanDemo.run();
    }
}
