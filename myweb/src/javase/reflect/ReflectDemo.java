package javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/6
 */
public class ReflectDemo {

    public static void main(String [] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        Class[] face = clazz.getInterfaces();
        for (Class c : face) {
            System.out.println(c);
        }

//  getClassDemo();
//        getConstructorDemo();
//            getFieldDemo();
//        getMethodDemo();
//        testNoParam();
//        testNotNullParam();
    }

    private static void testNotNullParam() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        //得到有参数的函数
        Method method = clazz.getMethod("showByParams",String.class,int.class);
        //创建无参的对象，调用方法
        Object object = clazz.newInstance();
        method.invoke(object,"有点点累",20);

    }

    /**
     * 得到方法
     */
    private static void getMethodDemo() throws ClassNotFoundException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        //获取该类以及父类中所有的公共方法
       /* Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }*/
       //获取本类中所有的方法,包括私有
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }



    }

    /**
     * 测试无参的普通方法的获取以及运行
     */
    private static void testNoParam() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        //得到无参的构造函数
        Method method = clazz.getMethod("show",null);
        //创建无参的
        Object object = clazz.newInstance();
        //运行方法
        method.invoke(object,null);
        //创建有参数的构造
        object = clazz.getConstructor(String.class,int.class).newInstance("有点累",21);
        method.invoke(object,null);


    }

    /**
     * 得到字段
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void getFieldDemo() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        //得到类中所有共有的字段
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }
        Field[] declaredfields = clazz.getDeclaredFields();
        for (Field f : declaredfields) {
            System.out.println(f);
        }
        Field field = clazz.getDeclaredField("name");
        //对私有字段的访问取消权限检查（暴力访问），使用field的setAccessible（true）
        field.setAccessible(true);
        //新建一个实例
        Object object = clazz.newInstance();
        //通过得到的字段对象将实例 以及要设置的值使用方法设置
        field.set(object,"我有点累了");
        //通过字段的对象的get()得到值
        System.out.println(field.get(object));

    }

    private static void getConstructorDemo() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        //通过类名反射得到该类的Class对象
        Class clazz = Class.forName(classname);
        //得到所有的构造函数
        Constructor[] constructor = clazz.getConstructors();
        for (Constructor c : constructor) {
            System.out.println(c);
        }
        //实例化一个不带参数的空构造
        clazz.newInstance();
        //使用clazz对象得到所需要的构造函数
        Constructor constructor1= clazz.getConstructor(String.class,int.class);
        System.out.println(constructor1);
        //通过构造器对象newInstance()进行对象的初始化
        constructor1.newInstance("小强",20);

    }

    private static void getClassDemo() throws ClassNotFoundException {
        //需要类的全路径，默认从src/bin目录寻找
        String classname = "javase.reflect.bean.Person";
        Class clazz = Class.forName(classname);
        System.out.println(clazz);
    }

}
