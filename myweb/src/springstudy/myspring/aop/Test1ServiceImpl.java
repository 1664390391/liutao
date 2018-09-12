package springstudy.myspring.aop;

/**
 * Created by 16643 on 2018/7/25.
 */
public class Test1ServiceImpl implements TestService,Test2Service {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("hello:"+name);
    }

    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public void sayByeBye() {
        System.out.println("sayByeBye:"+name);
        int i = 9/0;
    }
}
