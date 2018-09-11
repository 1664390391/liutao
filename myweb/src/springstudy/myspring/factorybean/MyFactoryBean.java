package springstudy.myspring.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * details:自定义的FactoryBean需要实现FactoryBean接口
 *
 * @author lt
 * @date 2018/9/11
 */
public class MyFactoryBean implements FactoryBean {
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    /**
     * 返回bean的对象
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {
        System.out.println("随便设置的一个属性str="+str);
        return new Car("Audi",200);
    }

    /**
     * 返回bean的类型
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 判断对象是否为单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
