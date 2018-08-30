package javase.lambdastudy;

/**
 * Created by lt on 2018/7/30.
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
