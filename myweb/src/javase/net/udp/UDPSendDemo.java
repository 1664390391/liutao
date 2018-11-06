package javase.net.udp;

import java.io.IOException;
import java.net.*;

/**
 * 测试UDP协议的发送端
 */
public class UDPSendDemo {
     public static void main(String [] args) throws IOException {
         String str = "";
        sendDemo(str);
     }

    /**
     * 一个简单的UDP协议发送端
     * @param str
     */
    private static void sendDemo(String str) throws IOException {
        //1、建立发送端港口，也就是UDP的socket服务:DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();
        //2、将要发送的字节数据封装到数据包中,并确定目的地和端口号
        byte [] buf = str.getBytes();
        DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),9999);
        //3、发送数据包
        ds.send(dp);
        //4、关闭Socket服务（系统底层资源）
        ds.close();
    }
}
