package springstudy.myspring4.webdemo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/14
 */
public class SpringServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //1、获取sprting配置文件的名称
        ServletContext servletContext = servletContextEvent.getServletContext();
        String config = servletContext.getInitParameter("configLocation");

        //2、创建IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //3、把IOC容器放在ServletContext的一个属性中
        servletContext.setAttribute("ApplicationContext",ac);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
