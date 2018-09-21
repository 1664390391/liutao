package springstudy.myspringmvc.firsttest;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * details:测试自定义视图，这里是自定义的，也可以使用已有的进行封装等等
 *
 * @author lt
 * @date 2018/9/21
 */
@Component
public class CustomView implements View {
    /**
     * 自定义视图的返回类型
     * @return
     */
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("<h1>test my custom view ,time :"+
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"</h1>");
    }
}
