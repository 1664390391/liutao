package springstudy.myspring4.spel;



/**
 * @author lt
 * @date 2018/8/20
 */
public class Person {

    private String name;
    private Car car;
    private String addr;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", addr='" + addr + '\'' +
                '}';
    }
}
