package springstudy.myspring4.jdbcbyanno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * details:测试spring链接jdbc
 *
 * @author lt
 * @date 2018/9/13
 */
public class JDBDTest {

    private ApplicationContext ac = null;
    private JdbcTemplate jdbcTemplate = null;
    private JdbcService jbdcService;
    {
        ac = new ClassPathXmlApplicationContext("springstudy/myspring4/jdbcbyanno/beans.xml");
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
        //IOC中只有jdbcServiceImpl名字的bean，但是这里可以使用多态的方式来实现
        jbdcService = (JdbcService) ac.getBean("jdbcServiceImpl");
    }

    public static void main(String [] args){
        new JDBDTest().jbdcService.testMoreAccountTransaction(2);
    }

    private void testUserUpdate() {
        String sql = "update user set userName = ? where userId = ?";
        jdbcTemplate.update(sql,"a1",001);
    }





}
