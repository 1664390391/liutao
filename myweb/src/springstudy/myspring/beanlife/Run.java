package springstudy.myspring.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/beanlife/beans.xml");
        BeanDemo beanDemo = (BeanDemo) ac.getBean("beanDemo");
        beanDemo.run();
        //关闭IOC容器，ApplicationContext类中没有，其子类有
        ac.close();

    }
}
