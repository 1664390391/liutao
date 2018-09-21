package springstudy.myspringmvc.firsttest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import springstudy.myspringmvc.bean.User;

import java.util.Date;
import java.util.Map;


/**
 * details：测试model类相关操作
 * @SessionAttributes注解:只能放在类上
 * 使用 String [] value  指定类中的方法中对应那些属性名字的数据可以放置到会话中（session）
 * 使用 Class<?>[] types  指定类型的属性值可以放置到会话中


 *
 * @author lt
 * @date 2018/9/20
 */
@SessionAttributes(value={"user"})
@Controller
@RequestMapping("modelDemo")
public class ModelDemo {

    /**
     * 跳转到登录页面
     */
    @RequestMapping("login")
    public String login(){
        return "login";
    }


    /**
     * 测试一个简单的自定义视图
     * @return
     */
    @RequestMapping("testCustomView")
    public String testCustomView(){
        //为什么是开头是小写，我猜测是根据自动装配的bean的name来找的
        return "customView";
    }


    /**
     * 测试modelandview类型
     * 其中可以包含视图信息和模型信息
     * 视图信息直接在创建ModelAndView对象的时候传入其构造器即可
     * 其中model数据会放到request域对象中？（request域对象？？？）
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView("firsttest/success");
        mv.addObject("time",new Date());
        mv.addObject("user",new User());
        return mv;
    }


    /**
     * 可以使用Spring mvc的一个内部接口Model来存储模型数据
     * 如果方法的入参是Map/Model/ModelMap类型（其实都是Map的相关类，操作方式都相同）,SpringMVC会将隐含的引用传递给这些入参
     * 实际上都是Map的子类，使用键值对存储需要返回的信息，然后返回的视图String会存放到ModelAndView中的view中，而Map等类型的入参会存放到Model中
     * @param map
     * @return
     */
    @RequestMapping("testModelMap")
    public String testModelMap(Model map){
//        map.put("name","xiaoming");
        map.addAttribute("name","xiaoming");
        map.addAttribute("time",new Date());
        return "firsttest/success";
    }












}
