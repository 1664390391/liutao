package springstudy.myspring.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by 16643 on 2018/7/26.
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

    /**
     *
     * @param o  执行完的代码如果有返回对象，则传入该参数
     * @param method    被调用方法的名字
     * @param objects   给method方法传入的参数
     * @param o1 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("关闭资源:"+method);
    }
}
