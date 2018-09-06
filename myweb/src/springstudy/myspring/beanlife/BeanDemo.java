package springstudy.myspring.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by 16643 on 2018/7/17.
 */
public class BeanDemo implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean {
    private String name;

    public BeanDemo(){
        System.out.println("第一步：配置的Bean对象被实例化到内存");
    }

    public BeanDemo(String name){
        System.out.println("测试构造函数注入值");
        this.name = name;
        System.out.println("name = "+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：使用set方法设置属性的值");
    }


    @Override
    public void setBeanName(String s) {
        System.out.println("第三步（如果需要）：实现BeanNameAware接口，通过setBeanName方法获取配置文件中该实例的bean名称："+s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第四步（如果需要）：实现BeanFactoryAware接口，可以获取beanFactory对象,即:"+beanFactory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第五步（如果需要）：实现ApplicationContextAware接口，可以获取上下文对象,即:"+applicationContext);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("第七步（如果需要）：实现InitializingBean接口，在属性设置完成之后，巴拉巴拉操作可以在这里玩一玩");

    }

//    @PostConstruct
    public void myinit(){
        System.out.println("第八步（如果需要）：自己的init方法可以玩一玩，在设置完属性之后，并且在afterinit方法之前会执行这个");

    }

    public void run(){
        System.out.println("第十步：spring对于bean全部加载完毕之后，得到上下文对象引用，得到配置的bean对象执行运行的方法");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("这时候容器已经被关闭，该步骤看不到输出，但是会执行。第十一步（如果需要）：自带的destroy方法启动");

    }

//    @PreDestroy
    public void mydestroy(){
        System.out.println("这时候容器已经被关闭，该步骤看不到输出，但是会执行。第十二步（如果需要）：玩一玩自定得destroy()");

    }
}
