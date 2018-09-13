package springstudy.myspring4.spring4_aopbyxml;

import org.springframework.stereotype.Component;

/**
 * Created by 16643 on 2018/7/25.
 */
public class TestServiceImpl2 implements TestService {


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
