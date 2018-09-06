package javase.reflect.bean;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/6
 */
public class MainBoard {
    public void run(){
        System.out.println("MainBoard run");
    }

    public void usePCI(PCI p) {// PCI p = 子类对象
        p.open();
        p.close();
    }
}
