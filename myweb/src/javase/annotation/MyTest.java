package javase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用反射的原理，模拟单元测试
 */
//设置自定义注解的使用范围，方法/字段/类
@Target(ElementType.METHOD)
//设置自定义注解的存活范围
@Retention(RetentionPolicy.RUNTIME)
public @interface MyTest {
}
