package springstudy.myspring.didemo;

/**
 * Created by 16643 on 2018/7/16.
 */
public class ToUpper implements ChangeWord {

    private String Str;

    public String getStr() {
        return Str;
    }

    public void setStr(String str) {
        Str = str;
    }

    @Override
    public String change() {
        return Str.toUpperCase();
    }
}
