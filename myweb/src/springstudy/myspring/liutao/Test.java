package springstudy.myspring.liutao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 16643 on 2018/7/12.
 */
public class Test {
    public static void main(String [] args){
        // 通过类路径获得ApplicationContext对象
        //这里的ApplicationContext对象最好使用单例模式分装成单态的
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)ac.getBean("user");
        user.sayHello();
//        User2 user2 = (User2)ac.getBean("user2");
//        user2.sayHello();
//        使用bean工厂方式
//        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
//        beanFactory.getBean("user");
    }
}
