package springstudy.myspringmvc.firsttest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/19
 */
@Controller
@RequestMapping("requestMappingDemo")
public class RequestMappingDemo {

    /**
     * 测试@RequestParam注解来映射请求参数
     * required属性：是否必须
     * defaultValue属性：如果不是必须的参数，且是基本数据类型，那么默认值不能为null，需要指定默认值
     * @return
     */
    @RequestMapping(value = "testRequestParam")
    public String testRequestParam(@RequestParam("username") String username,
                                   @RequestParam(value = "age",required = false,defaultValue = "-1") int age,HttpServletRequest request){
        System.out.println("testRequestParam , username="+username+",age="+age);
        Object s = request.getAttribute("username");
        return  "firsttest/success";
    }


    /**
     * 通过@PathVariable可以将URL中占位符参数绑定到控制器处理方法的入参中（目前没理解有啥作用）
     * @param id
     * @return
     */
    @RequestMapping(value = "testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id){
        System.out.println("testPathVariable_id="+id);
        return  "firsttest/success";
    }

    /**
     * 测试RequestMapping的params属性和headers属性
     * params = {"username","age != 10"}：表示必须含有username和age两个属性，且age不能等于10，headers属性同理
     * 但是经过测试，上述这么写的话，username属性必须加上，但是可以不必包含age，如果有age属性则不能为10，貌似和其定义有一些不一样，需要验证
     * @return
     */
    @RequestMapping(value = "testParamsAndHeadsMethod",params = {"username","age!=10"})
    public String testParamsAndHeadsMethod(HttpServletRequest request){
        return  "firsttest/success";
    }

    /**
     * 常用属性：使用method来确定请求方式
     * @return
     */
    @RequestMapping(value = "testPostMethod",method = RequestMethod.POST)
    public String testPostMethod(){
        System.out.println("testPostMethod() run ");
        return  "firsttest/success";
    }
}
