package springstudy.myspring.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by 16643 on 2018/7/17.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("第六步后置处理器（如果需要）：配置BeanPostProcessor对象的bean，配置文件中其他的bean回和该bean关联，实例化bean的时候就会自动调用这里的before方法。类似于web中的filter的功能。");
        System.out.println("这里使用了aop的思想，对每个实例化的bean之前进行一些处理。");
        System.out.println("postProcessBeforeInitialization方法信息:"+o);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("第九步（如果需要）：后置处理器的after方法可以玩一玩，这里同样是对每一个bean初始化完成之后，使用aop的思想进行一系列的瞎几把操作");
        System.out.println("postProcessAfterInitialization方法信息:"+o);
        return o;
    }
}
