package springstudy.myspring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * details:模拟静态工厂方法，直接调用某一个类的静态方法就可以返回bean实例
 *
 * @author lt
 * @date 2018/9/10
 */
public class StaticCarFactory {
    private static Map<String,Car> map = new HashMap<>();
    //静态代码块对map进行类加载的时候就初始化
    static {
        map.put("Audi",new Car("Audi",3000));
        map.put("Ford",new Car("Ford",1000));
    }

    //静态工厂方法
    public static Car getCar(String name){
        return map.get(name);
    }
}
