package myspring;

/**
 * @author lt
 * @date 2018/8/20
 */
public class User {

    User(){
        System.out.println("User constructor");
    }

    private String name;

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
}
