package javase.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * 测试UDP协议的发送端，模拟一个简单的UDP协议发送端
 */
public class UDPSendDemo {
     public static void main(String [] args) throws IOException {
         System.out.println("发送端启动");
         String str = "老夫就是模拟UDP的发送端";
         //1、建立发送端港口，也就是UDP的socket服务:DatagramSocket对象
         //注意：不明确端口号也能够发送数据，只要数据包明确发送的目的地即可，当然也可以指定发送端的端口号
         DatagramSocket ds = new DatagramSocket(8888);
         //2、将要发送的字节数据封装到数据包中,并确定目的地和端口号
         byte [] buf = str.getBytes();
         DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),9999);
         //3、发送数据包
         ds.send(dp);
         //4、关闭Socket服务（系统底层资源）
         ds.close();
     }

    /**
     * 一个简单的UDP协议发送端
     * @param str
     */
//    private static void sendDemo(String str) throws IOException { }
}
