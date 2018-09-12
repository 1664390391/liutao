package springstudy.myspring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
//        springAopTest();
        ProxyTest();
    }

    /**
     * 使用动态代理的方式模拟前置和后置通知，但是相对复杂
     */
    private static void ProxyTest() {
        TestService target = new Test1ServiceImpl();
        TestService  ts = new DynamicProxyMethod(target).getLoggingProxy();
        int result = ts.add(1,2);
        System.out.println("result="+result);
    }

    private static void springAopTest() {
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
