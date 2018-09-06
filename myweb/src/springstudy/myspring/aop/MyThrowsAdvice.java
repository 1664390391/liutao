package springstudy.myspring.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by 16643 on 2018/7/26.
 */
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Method m,Object [] os,Object target ,Exception e){
        System.out.println("出事了好烦啊:"+e.getMessage());
    }
}
