package springstudy.myspring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


/**
 * Created by 16643 on 2018/7/21.
 */
public class App {
    public static void main(String [] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("springstudy/myspring/collection/beans.xml");
        Department d = (Department) ac.getBean("department");
        System.out.println(d.getDepartName());
        //获取配置的数组
        for(String s:d.getEmployeeName()){
            System.out.println(s);
        }
        System.out.println("***********获取配置的List************");
        //获取配置的List,输出顺序取决于配置bean的顺序
        for(Employee e : d.getEmpList()){
            System.out.println("empname="+e.getName());
        }
        System.out.println("***********获取配置的set************");
        //获取配置的set,输出顺序取决于配置bean的顺序
        for(Employee e : d.getEmpSet()){
            System.out.println("empname="+e.getName());
        }
        System.out.println("***********获取配置的map************");
        //获取配置的map,输出顺序取决于配置bean的顺序
        for(Map.Entry<Integer,Employee> entry : d.getEmpMap().entrySet()){
            System.out.println("key="+entry.getKey()+"    ..value="+entry.getValue().getName());
        }
    }
}
