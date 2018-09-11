package springstudy.myspring.faceinterbean;

/**
 * Created by 16643 on 2018/7/16.
 */
public class ToLower implements ChangeWord {
    private String Str;

    public ToLower(){
        System.out.println("ToLower对象呗创建");
    }

    public String getStr() {
        return Str;
    }

    public void setStr(String str) {
        Str = str;
    }
    @Override
    public String change() {
        return Str.toLowerCase();
    }
}
