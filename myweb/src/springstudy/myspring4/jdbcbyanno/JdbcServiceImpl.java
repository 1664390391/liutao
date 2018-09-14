package springstudy.myspring4.jdbcbyanno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/13
 */
@Repository
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 测试转账， 002号+100,001号-100，最基本的事务
     *
     * REQUIRED类型的事务：走调用者的事务
     * REQUIREDNEW类型的事务，执行的事务调用者的事务被挂起，单独走自己事务，走完之后调用者的事务在继续
     * @param money
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testAccountUpdate(int money) {
        String sql2 = "update account1 set money = money + ?  where id = ?";
        jdbcTemplate.update(sql2,money,002);

        //先检查账户余额是否足够，若不够，则提示
        String checkSql = "select money from account where id = ?";
        int balance = jdbcTemplate.queryForObject(checkSql,Integer.class,001);
        if( balance < money){
            throw new RuntimeException("余额不足");
        }
        String sql1 = "update account set money = money - ?  where id = ?";
        jdbcTemplate.update(sql1,money,001);
    }

    /**
     * 测试多个事务的事务传播,默认类型,走同一个事务
     */
    @Transactional
    @Override
    public void testMoreAccountTransaction(int count) {
        for(int i = 0;i< count;i++){
            testPrivateAccountUpdate(1000);
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testPrivateAccountUpdate(int money) {
        String sql2 = "update account set money = money + ?  where id = ?";
        jdbcTemplate.update(sql2,money,002);

        //先检查账户余额是否足够，若不够，则提示
        String checkSql = "select money from account where id = ?";
        int balance = jdbcTemplate.queryForObject(checkSql,Integer.class,001);
        if( balance < money){
            throw new RuntimeException("余额不足");
        }
        String sql1 = "update account set money = money - ?  where id = ?";
        jdbcTemplate.update(sql1,money,001);
    }





}
