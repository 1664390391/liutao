package springstudy.myspring.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import springstudy.myspring.annotation.service.UserService;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
//模拟控制层，该注解标识控制层组件，不加默认bean的名称就是userController
@Controller("userController")
public class UserController {

    private UserService userService;

    //自动装配属性userService
    @Autowired
    //这里找到两个userService的bean，通过指定名称来使用接口中特定的实现类
    @Qualifier("userServiceImpl")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void execute(){
        System.out.println("UserController execute() run");
        userService.save();
    }
}
