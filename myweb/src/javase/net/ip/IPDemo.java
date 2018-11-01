package javase.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * details:测试InetAddress对象的使用
 *
 * @author lt
 * @date 2018/11/1
 */
public class IPDemo {
    public static void main(String [] args) throws UnknownHostException {
        //获取本机主机ip地址对象
        InetAddress ip = InetAddress.getLocalHost();

        //获取主机名得到主机的ip，主机名可以是ip的文本表示形式，也可以机器名
        ip = InetAddress.getByName("www.sina.com");

        System.out.println("ip地址："+ip.getHostAddress());
        System.out.println("地址名称："+ip.getHostName());
    }
}
