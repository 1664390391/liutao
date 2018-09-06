package springstudy.myspring.autowire;

/**
 * Created by 16643 on 2018/7/21.
 */
public class Master {
    private String name;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
