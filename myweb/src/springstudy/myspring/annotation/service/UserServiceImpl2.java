package springstudy.myspring.annotation.service;

import org.springframework.stereotype.Service;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
@Service("userServiceImpl2")
public class UserServiceImpl2 implements UserService {
    @Override
    public void save() {
        System.out.println("UserServiceImpl2就是来捣乱的");
    }
}
