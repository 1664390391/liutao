package javase.collections.bean;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/3
 */
public class Worker extends Person{
    public Worker(String name, int age) {
        super(name,age);
    }

    public Worker() {

    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
