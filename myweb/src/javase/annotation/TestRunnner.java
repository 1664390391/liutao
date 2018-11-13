package javase.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunnner {
     public static void main(String [] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        //通过反射得到需要运行的Class对象
         Class clazz = Run.class;
         //得到类中自己的方法
         Method [] mds = clazz.getDeclaredMethods();
         //遍历所有的方法
         for (Method md : mds) {
             //判断方法上是否加有对应的注解
             boolean b = md.isAnnotationPresent(MyTest.class);
//             System.out.println(md.getName()+":"+b);
             if(b){
                 md.invoke(clazz.newInstance(),null);
             }
         }
     }
}
