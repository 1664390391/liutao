package springstudy.myspring.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 16643 on 2018/7/25.
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    /**
     *
     * @param method 被调用方法的名字
     * @param objects 给method方法传入的参数
     * @param target 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("记录日志:"+method);
    }
}
