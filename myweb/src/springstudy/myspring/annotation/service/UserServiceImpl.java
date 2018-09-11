package springstudy.myspring.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springstudy.myspring.annotation.repository.UserRepository;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
//模拟业务层，该注解标识业务层组件，不加默认就是userServiceImpl，也可以加指定的名字的value值
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl save() run");
        userRepository.save();
    }
}
