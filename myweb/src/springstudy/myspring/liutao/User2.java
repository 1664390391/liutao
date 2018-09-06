package springstudy.myspring.liutao;

/**
 * @author  lt
 * Created by 16643 on 2018/7/12.
 */
public class User2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello(){
        System.out.println("hello222："+name);
    }
}
