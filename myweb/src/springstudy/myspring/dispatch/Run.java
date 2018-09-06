package springstudy.myspring.dispatch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/17.
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/dispatch/beans.xml");
        DBUtil dbUtil = (DBUtil) ac.getBean("dbutil");
        System.out.println("username="+dbUtil.getUsername());
        System.out.println("password="+dbUtil.getPassword());
    }
}
