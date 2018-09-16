package springstudy.myspring4.webdemo.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * details:在web中使用spring的基本思路
 * 配置好相关参数之后。web项目每次加载的时候都会使用拦截器执行当前类的初始化方法
 * 初始化完成之后spring的基本配置已经放置在servletContext的域对象中了，只要servlet得到属性并调用相关方法即可
 * 但是实际开发中还是spring mvc整合，不需要使用servelt
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
