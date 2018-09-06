package javase.reflect;

import javase.reflect.bean.MainBoard;
import javase.reflect.bean.PCI;
import javase.reflect.bean.SoundCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * details:反射小练习，测试电脑运行以及额外添加功能那个
 *
 * @author lt
 * @date 2018/9/6
 */
public class ReflectTest {
    public static void main(String [] args) throws Exception {
        //原始的电脑运行
        MainBoard mb = new MainBoard();
        mb.run();
        //电脑对外暴露PCI接口，怎么获得实现接口的子类对象并调用呢？
        //原始方法，使用多态，但是耦合性还是很高
//        mb.usePCI(new SoundCard());
        //新方法，使用反射机制，读取配置文件中的信息，并创建实例运行-- 这里代码并不健壮
        File configFile = new File("src\\pci.properties");
//        System.out.println(File.separator);
        System.out.println(System.getProperty("user.dir"));
        //创建属性集合对象，键值对
        Properties properties = new Properties();
        //然后使用流读取文件
        FileInputStream fileInputStream = new FileInputStream(configFile);
        //加载流中的数据，放入配置文件
        properties.load(fileInputStream);
        for(int i = 0;i< properties.size();i++){
            //得到所有的pci接口名称
            String pciname = properties.getProperty("pci"+(i+1));
            Class clazz = Class.forName(pciname);
            PCI pci = (PCI) clazz.newInstance();
            mb.usePCI(pci);

        }
        fileInputStream.close();
    }
}
