package springstudy.myspring.genericsdi;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/11
 */
public abstract class BaseService<T> {
    @Autowired
    protected BaseDao<T> baseDao;

    public void add(){
        System.out.println("BaseService add run");
        System.out.println(baseDao);
    }
}
