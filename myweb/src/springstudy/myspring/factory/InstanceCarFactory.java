package springstudy.myspring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * details:模拟实例工厂方法，即先需要创建工厂本身，在使用工厂对象变量调用普通方法来返回需要的bean 的实例，这里也就是new Car()
 *
 * @author lt
 * @date 2018/9/10
 */
public class InstanceCarFactory {
    private Map<String,Car> map = new HashMap<>();
    //构造方法在类创建对象的时候对map进行就初始化
    public InstanceCarFactory() {
        map.put("Audi",new Car("Audi",3000));
        map.put("Ford",new Car("Ford",1000));
    }

    //普通方法返回Car实例
    public  Car getCar(String name){
        return map.get(name);
    }
}
