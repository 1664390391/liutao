package springstudy.myspring4.spring4_aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * details:测试多个切面的顺序，出现多个切面的话是没有规律的，但是可以在类上加注解，指定值，越小的值优先级越高
 *
 * @author lt
 * @date 2018/9/12
 */
@Order(1)
@Aspect
@Component
public class MoreAspectJTest {

//    //后置通知，方法执行之后执行（无论是否出现异常都会被执行），但是这时还不能访问目标方法的结果，因为这个在方法结果之前执行
//    @Before("execution(* springstudy.myspring4.spring4_aop.*.*(..))")
//    public void beforeMethod(){
//      System.out.println("我是其他切面前置。。。测试执行顺序");
//    }

//    //后置通知，方法执行之后执行（无论是否出现异常都会被执行），但是这时还不能访问目标方法的结果，因为这个在方法结果之前执行
//    @After("execution(* springstudy.myspring4.spring4_aop.*.*(..))")
//    public void afterMethod(){
//      System.out.println("我是其他切面后置。。。测试执行顺序");
//    }

    /**
     * 返回 通知，程序正常结束执行的代码。可以访问到返回至
     * @param joinPoint
     */
    @AfterThrowing(value = "execution(* springstudy.myspring4.spring4_aop.*.*(..))")
    public void afterReturnMethod(JoinPoint joinPoint){
        System.out.println("我是其他切面异常通知。。。测试执行顺序");
    }


}
