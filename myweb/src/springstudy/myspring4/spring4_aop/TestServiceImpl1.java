package springstudy.myspring4.spring4_aop;

import org.springframework.stereotype.Component;

/**
 * Created by 16643 on 2018/7/25.
 */
@Component()
public class TestServiceImpl1 implements TestService {


    @Override
    public void sayHello() {
        System.out.println(" sayHello() run");
    }

    @Override
    public int add(int i, int j) {
        return i+j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }


    public void sayByeBye() {
        System.out.println(" sayByeBye() run");
    }
}
