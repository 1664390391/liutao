package springstudy.myspring.liutao;

/**
 * @author  lt
 * Created by 16643 on 2018/7/12.
 */
public class User {
    private String name;

    private User2 user2;

    public User(){
        System.out.println("User对象呗创建");
    }

    public User2 getUser2() {
        return user2;
    }

    public void setUser2(User2 user2) {
        this.user2 = user2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello："+name);
//        user2.sayHello();
    }
}
