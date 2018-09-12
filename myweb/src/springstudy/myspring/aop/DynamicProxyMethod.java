package springstudy.myspring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * details:使用动态代理的方式解决类似aop这种切面编程效果
 *
 * @author lt
 * @date 2018/9/12
 */
public class DynamicProxyMethod {

    private TestService target;

    public DynamicProxyMethod(TestService target) {
        this.target = target;
    }


    public TestService getLoggingProxy(){
        TestService proxy = null;
        //确认代理对象由哪一个类的加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //获得代理对象的类型，即其中有哪些方法。
        Class [] interfaces = new Class[]{TestService.class};
        InvocationHandler h = new InvocationHandler() {
            /**
             *
             * @param proxy 正在代理的那个对象，一般不再invoke()中调用该对象，因为对象调用自己方法，自己方法在调用对象中自己的方法，程序直接挂掉，其他地方可能会使用
             * @param method 正在被调用的方法
             * @param args 调用方法是传入的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //模拟前置通知
                System.out.println(methodName + " is begin with"+ Arrays.asList(args));
                //执行方法
                Object result = method.invoke(target,args);
                //模拟后置通知
                System.out.println(methodName + " is end");
                return result;
            }
        };


        proxy = (TestService) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
