package springstudy.myspringmvc.firsttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * details:spring mvc 初体验
 *
 * @author lt
 * @date 2018/9/18
 */
@Controller()
public class HelloWorld {


    /**
     * 1、使用 @RequestMapping注解来映射请求的url
     * 2、返回值会通过视图解析器解析为实际的物理视图，也就是这里的InternalResourceViewResolver
     * 通过 perfix+  returnVal + suffix这样的方式得到实际的物理视图，然后做转发操作
     *
     *
     * @return
     */
    @RequestMapping("/toSuccessPage")
    public String hello(){
        System.out.println("hello world");
        return "firsttest/success";
    }


}
