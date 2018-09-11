package springstudy.myspring.genericsdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
public class Run {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/genericsdi/beans.xml");
        UserService userService = (UserService) ac.getBean("userService");
        //调用add()，然后子类并未定义，寻找父类，父类有泛型，根据泛型找到Dao的子类具有该泛型的子类
        userService.add();
    }
}
