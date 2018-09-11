package springstudy.myspring.collection;

import java.util.Properties;

/**
 * details:测试类似Map的properties属性的注入
 * Hashtable的子类，一般用于数据库连接等配置
 *
 * @author lt
 * @date 2018/9/10
 */
public class DataSource {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
