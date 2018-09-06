package springstudy.myspring4.firsttest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lt
 * @date 2018/8/20
 */
public class TestSptring1 {
    public static void main(String [] args){
        //加载spring的容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获得配置的bean对象。
        User u = (User) ac.getBean("user");
        u.sayhello();
    }
}
