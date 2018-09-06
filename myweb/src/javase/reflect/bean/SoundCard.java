package javase.reflect.bean;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/6
 */
public class SoundCard implements PCI {
    @Override
    public void open() {
        System.out.println("SoundCard open");
    }

    @Override
    public void close() {
        System.out.println("SoundCard close");
    }
}
