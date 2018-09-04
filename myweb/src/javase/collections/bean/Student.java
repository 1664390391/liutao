package javase.collections.bean;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/3
 */
public class Student extends Person{
    public Student(String name, int age) {
        super(name,age);
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }
}
