package springstudy.myspring.beanlife;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/10
 */
public class OtherBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("OtherBean set()  run");
        this.name = name;
    }

    public OtherBean() {
        System.out.println("OtherBean() run");
    }
}
