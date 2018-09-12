package springstudy.myspring4.spring4_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/12
 */
//把这个类声明为一个切面，以及把类放到IOC容器中管理
@Order(2)
@Aspect
@Component
public class AspectJDemo {

    //声明该方法是一个前置通知，在目标方法开始之前执行。
    //joinPoint参数表示一些细节
//    @Before("execution(* springstudy.myspring4.spring4_aop.*.*(..))")
//    public void beforeMethod(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("使用AspectJ方式测试前置通知方法 ："+methodName+"以及参数："+args);
//    }
//
//    //后置通知，方法执行之后执行（无论是否出现异常都会被执行），但是这时还不能访问目标方法的结果，因为这个在方法结果之前执行
//    @After("execution(* springstudy.myspring4.spring4_aop.*.*(..))")
//    public void afterMethod(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("使用AspectJ方式测试后置通知方法 ："+methodName+"以及参数："+args);
//    }

    /**
     * 返回 通知，程序正常结束执行的代码。可以访问到返回至
     * @param joinPoint
     * @param result
     */
//    @AfterReturning(value = "execution(* springstudy.myspring4.spring4_aop.*.*(..))",returning = "result")
//    public void afterReturnMethod(JoinPoint joinPoint,Object result){
//        String methodName = joinPoint.getSignature().getName();
//        List<Object> args = Arrays.asList(joinPoint.getArgs());
//        System.out.println("使用AspectJ方式测试返回通知方法 ："+methodName+"以及参数："+args+",其结果为："+result);
//    }

    /**
     * 配置异常通知，想当于catch，可以自定义处理异常
     * @param joinPoint
     * @param e : 异常的类型，可以定义最大范围Exception,也可以自定义
     */
    @AfterThrowing(value = "execution(* springstudy.myspring4.spring4_aop.*.*(..))",throwing = "e")
    public void afterReturnMethod(JoinPoint joinPoint,Exception e){
        System.out.println("使用AspectJ方式测试异常通知方法出现的异常 ："+e);
    }

    /**
     * 类似于动态代理的全过程
     * @param pjd 必须要携带该类型参数
     * @return 必须有返回值
     */
   /* @Around("execution(* springstudy.myspring4.spring4_aop.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd){
        Object result = null;
        try {
            //前置通知
            System.out.println("前置通知...");
            //方法执行
            result = pjd.proceed();
            //返回通知
            System.out.println("返回通知执行...,返回值是："+result);
        } catch (Throwable e) {
            System.out.println("异常通知是："+e);
        }
        System.out.println("后置通知执行...");
        return result;
    }*/


}
