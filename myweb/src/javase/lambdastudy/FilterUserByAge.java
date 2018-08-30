package javase.lambdastudy;

/**
 * Created by lt on 2018/7/30.
 * Function :
 * Params :
 * Return :
 */
public class FilterUserByAge implements myInter<User> {
    @Override
    public boolean test(User user) {
        return user.getAge() > 15;
    }
}
