package springstudy.myspringmvc.firsttest.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * details:spring mvc 初体验
 *
 * @author lt
 * @date 2018/9/18
 */
@Controller
public class HelloWorld {


    /**
     * 1、使用 @RequestMapping注解来映射请求的url
     * 2、返回值会通过视图解析器解析为实际的物理视图，
     * @return
     */
    @RequestMapping("toSuccessPage")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }


}
