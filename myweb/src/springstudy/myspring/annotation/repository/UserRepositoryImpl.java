package springstudy.myspring.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
//模拟持久化层，该注解标识持久层组件
@Repository("userRepositoryImpl")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepositoryImpl save() run");
    }
}
