package springstudy.myspringmvc.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * details:可以用来设置全局的异常处理
 * 注意点
 * 1、@ExceptionHandler方法的入参可以加入Exception类型的参数，即异常对象
 * 2、@ExceptionHandler方法的入参不能传入map，如果希望将异常的信息传递，那么需要使用 ModelAndView对象
 * 3、@ExceptionHandler方法标记的异常有优先级问题，按照异常的“远近”来确定优先级
 * 4、@ControllerAdvice:如果当前的类中找不到@ExceptionHandler方法来处理当前的异常，
 *  那么就会去@ControllerAdvice标记的类中的@ExceptionHandler对应的方法处理异常
 *
 * @author lt
 * @date 2018/10/9
 */
@ControllerAdvice
public class myExceptionHandler {
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView testArithmeticException(Exception e){
        System.out.println("testArithmeticException :"+ e);
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView testRuntimeException(Exception e){
        System.out.println("testRuntimeException :"+ e);
        ModelAndView mv = new ModelAndView("error");
        return mv;
    }
}
