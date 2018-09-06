package springstudy.myspring.aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by 16643 on 2018/7/26.
 */
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("方法调用前");
        //让被代理的对象执行他本身的方法
        Object obj =  methodInvocation.proceed();
        System.out.println("方法调用后啊。。。。");
        return obj;
    }
}
