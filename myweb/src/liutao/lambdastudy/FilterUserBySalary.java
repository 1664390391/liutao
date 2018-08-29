package liutao.lambdastudy;

/**
 * Created by ym on 2018/7/30.
 * Function :
 * Params :
 * Return :
 */
public class FilterUserBySalary implements myInter<User> {
    @Override
    public boolean test(User user) {
        return user.getSalary() > 1500;
    }
}
