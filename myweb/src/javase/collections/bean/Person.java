package javase.collections.bean;

/**
 * details:Person实体类，实现Comparable接口进行内部自定义的比较
 *
 * @author lt
 * @date 2018/9/1
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 默认根据年龄排序，如果年纪相同，则根据姓名进行排序，如果都一样，则认为 是相同的
     * @param o
     * @return
     */
    @Override
    public int compareTo(Person o) {
        //当前对象比传入对象年纪大，则认为该数据大于传入对象
        int temp = getAge() - o.getAge();
        return temp == 0 ? getName().compareTo(o.getName()) : temp;
    }
}
