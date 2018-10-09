package springstudy.myspringmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * details:
 *
 * @author lt
 * @date 2018/10/9
 */
public class myInterceptor2 implements HandlerInterceptor{
    /**
     * 在业务处理器请求之前被调用，在该方法中对用户请求request进行处理，
     * 也就是说该方法最先调用
     * 若返回true，则继续调用后续的拦截器和目标方法
     * 若返回值为false，则不会继续调用后续的拦截器和目标方法
     *
     * 可以考虑做权限，日志，事务配置等
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("myInterceptor2 - preHandle() run");
//        return false;
        return true;
    }

    /**
     * 调用目标方法处理完请求之后，渲染视图（返回响应）之前被调用
     * 一般可以用于加属性等
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("myInterceptor2 - postHandle() run");
    }

    /**
     * 渲染视图之后被调用
     * 可以用来清理资源等
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("myInterceptor2 - afterCompletion() run");
    }
}
