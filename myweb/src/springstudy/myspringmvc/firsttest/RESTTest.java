package springstudy.myspringmvc.firsttest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * details:测试REST对应的增删改查
 * 1、配置webxml中的HiddenHttpMethodFilter类管理所有的请求，并进行过滤处理
 * 2、配置页面上的请求，get和post正常，但是想要转化成put请求和delete请求，则需要在post请求中加上一个name 为_method 的隐藏域，并且值为对应转化的请求类型
 * 3、如果转化成put请求和delete请求请求，那么在控制层接受的时候使用RequestMapping注解中的method对应属性进行接受
 * 个人觉得比较麻烦
 * @author lt
 * @date 2018/9/19
 */
@Controller
public class RESTTest {


    /**
     * 模拟REST中的update形式
     * @PathVariable 传入的id
     * @return
     */
    @RequestMapping(value = "TestRESTPOST/{id}",method = RequestMethod.PUT)
    public String TestRESTPOSTTOPUT(@PathVariable("id") String id){
        System.out.println("模拟REST中的update形式，id= "+id);
        return "success";
    }

    /**
     * 模拟REST中的DELETE形式
     * @PathVariable 传入的id
     * @return
     */
    @RequestMapping(value = "TestRESTPOST/{id}",method = RequestMethod.DELETE)
    public String TestRESTPOSTTODELETE(@PathVariable("id") String id){
        System.out.println("模拟REST中的DELETE形式，id= "+id);
        return "success";
    }

    /**
     * 模拟REST中的Insert形式
     * @return
     */
    @RequestMapping(value = "TestRESTPOST",method = RequestMethod.POST)
    public String TestRESTPOST(){
        System.out.println("模拟REST中的Insert形式 ");
        return "success";
    }

    /**
     * 模拟REST中的GET形式
     * @PathVariable 传入的id
     * @return
     */
    @RequestMapping(value = "testRESTGET/{id}",method = RequestMethod.GET)
    public String TestRESTGET(@PathVariable("id") String id){
        System.out.println("模拟REST中的GET形式，id= "+id);
        return "success";
    }

}
