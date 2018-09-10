package springstudy.myspring.factory;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/10
 */
public class Car {
    private String name;
    private double speed;

    public Car() {
    }

    public Car(String name, double speed) {
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
