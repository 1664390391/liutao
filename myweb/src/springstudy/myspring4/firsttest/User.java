package springstudy.myspring4.firsttest;

/**
 * @author lt
 * @date 2018/8/20
 */
public class User {

    private String name;
    private int age;
    private double salary;


    User(){
        System.out.println("User constructor");
    }


    public User(String name, double salary) {
        System.out.println("constrcutor  User(String name, double salary) run");
        this.name = name;
        this.salary = salary;
    }

    public User(String name, int age) {
        System.out.println("constrcutor  User(String name, int age) run");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set User name");
        this.name = name;
    }

    public void sayhello(){
        System.out.println("hello..."+name);
    }




    @Override
    public String toString() {
        System.out.println("toString run");
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

}
