package springstudy.myspringmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import springstudy.myspringmvc.bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        return  "controller/success";
    }


    /**
     * 通过@PathVariable可以将URL中占位符参数绑定到控制器处理方法的入参中（目前没理解有啥作用）
     * @param id
     * @return
     */
    @RequestMapping(value = "testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id){
        System.out.println("testPathVariable_id="+id);
        return  "controller/success";
    }

    /**
     * 测试RequestMapping的params属性和headers属性
     * params = {"username","age != 10"}：表示必须含有username和age两个属性，且age不能等于10，headers属性同理
     * 但是经过测试，上述这么写的话，username属性必须加上，但是可以不必包含age，如果有age属性则不能为10，貌似和其定义有一些不一样，需要验证
     * @return
     */
    @RequestMapping(value = "testParamsAndHeadsMethod",params = {"username","age!=10"})
    public String testParamsAndHeadsMethod(HttpServletRequest request){
        return  "controller/success";
    }

    /**
     * 常用属性：使用method来确定请求方式
     * @return
     */
    @RequestMapping(value = "testPostMethod",method = RequestMethod.POST)
    public String testPostMethod(){
        System.out.println("testPostMethod() run ");
        return  "controller/success";
    }

    /**
     * 常用属性：测试参数的传递
     * @return
     */
    @RequestMapping(value = "testParamTransferMethod")
    public String testParamTransferMethod(String id){
        System.out.println("testParamTransferMethod() run , and id = "+ id);
        return  "controller/success";
    }


    /**
     * 测试服务器内部的转发
     * @param request
     * @param response
     */
    @RequestMapping("/testRequestDispatcher")
    public void testRequestDispatcher(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始转发");
        try {
            //内部转发，使用同一个请求，带上目前的请求和响应数据
            request.getRequestDispatcher("/success").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("结束转发");

    }

    /**
     * 测试重定向
     * @param request
     * @param response
     */
    @RequestMapping("/testsendRedirect")
    public void testsendRedirect(HttpServletRequest request, HttpServletResponse response){
        System.out.println("开始重定向");
        try {
            //在响应信息中，告诉客户端你需要重新请求
//            response.sendRedirect("/success");
            String s = request.getContextPath();
            response.sendRedirect(s+"/success");
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束重定向");

    }

    /**
     * 上述两个只是简单的使用Servlet的request和response进行转发和重定向
     * 在默认情况下，客户端请求在后台都是执行的转发，这里测试mvc中的重定向
     */
    @RequestMapping("/testMVCRedirect")
    public String testMVCRedirect(){
        System.out.println("开始MVC重定向");
        //这里目前还不支持任意重定向位置，不知道是为嘛..
        return "redirect:/success";

    }

    @ResponseBody
    @RequestMapping("testJSON")
    public List<User> testJSON(){
        return new ArrayList<User>(){{
            add(new User("xiaoqiang",11));
            add(new User("wangcai",88));
        }};
    }


    @RequestMapping("testFileUpload")
    public String testFileUpload(String desc, MultipartFile file){
        System.out.println("desc:"+desc);
        System.out.println("file:"+file.getOriginalFilename());
        //可以使用流进行上传打印等
        return "success";
    }

    @RequestMapping("teseException")
    public String teseException(int i){
        System.out.println("result :"+10/i);
        return "success";
    }


//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView testArithmeticException(Exception e){
//        System.out.println("testInnerArithmeticException :"+ e);
//        ModelAndView mv = new ModelAndView("error");
//        return mv;
//    }




}
