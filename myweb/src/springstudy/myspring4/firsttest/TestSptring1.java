package springstudy.myspring4.firsttest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lt
 * @date 2018/8/20
 */
public class TestSptring1 {
    public static void main(String [] args){
        //加载spring的IOC容器
        //ApplicationContext代表spring的IOC容器，ClassPathXmlApplicationContext:是ApplicationContext接口的实现类，该实现类从类路径下加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得配置的bean对象。利用id定位到IOC容器中的bean
        User u = (User) ac.getBean("user");
        u.sayhello();

        User u1 = (User) ac.getBean("user1");
        System.out.println(u1.toString());
        User u2 = (User) ac.getBean("user2");
        System.out.println(u2.toString());
    }
}
