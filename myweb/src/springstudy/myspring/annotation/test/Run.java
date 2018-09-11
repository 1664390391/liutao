package springstudy.myspring.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springstudy.myspring.annotation.controller.UserController;
import springstudy.myspring.annotation.service.UserServiceImpl;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
public class Run {
    /*
        测试spring注解方式进行bean的管理和操作
     */
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/annotation/beans.xml");
        UserController userController = (UserController) ac.getBean("userController");
        userController.execute();


    }
}
