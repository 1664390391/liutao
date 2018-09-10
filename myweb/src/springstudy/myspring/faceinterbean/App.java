package springstudy.myspring.faceinterbean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by 16643 on 2018/7/16.
 */
public class App {
    public static void main(String [] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/faceinterbean/beans.xml");
        //传统的方式
//        ToUpper toUpper = (ToUpper) ac.getBean("ChangeWord");
//        System.out.println(toUpper.change());
        //面向接口的方式
//        ChangeWord changeWord = (ChangeWord) ac.getBean("ChangeWord");
//        System.out.println(changeWord.change());
//        使用bean工厂的方式  (不常使用，也不建议使用)
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("springstudy/myspring/faceinterbean/beans.xml"));
//        ChangeWord changeWord = (ChangeWord) beanFactory.getBean("ChangeWord");
//        changeWord.change();
    }
}
