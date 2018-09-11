package springstudy.myspring4.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/10
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring4/spel/beans.xml");
        Person p = (Person) ac.getBean("person");
        System.out.println(p);
    }
}
