package springstudy.myspring4.spring4_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring4/spring4_aop/beans.xml");

        TestService ts = (TestService) ac.getBean("testServiceImpl1");

        System.out.println(ts.getClass().getName());

        int result = ts.div(10,0);
        System.out.println("方法执行结果为："+result);

    }


}
