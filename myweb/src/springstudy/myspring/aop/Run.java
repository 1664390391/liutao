package springstudy.myspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/aop/beans.xml");
        TestService ts = (TestService) ac.getBean("proxyFactoryBean");
        ts.sayHello();
        System.out.println("***********************");
        ((Test2Service)ts).sayByeBye();
        long l = 312L;
//        Test2Service ts2 = (Test2Service) ac.getBean("proxyFactoryBean");
//        ts2.sayByeBye();
//        System.out.println("master="+m.getName());

    }
}
