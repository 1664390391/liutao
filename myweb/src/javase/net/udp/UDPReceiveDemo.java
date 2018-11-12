package javase.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 模拟UDP接收端
 */
public class UDPReceiveDemo {
    /**
     * 思路：
     * 1、和发送端一样，建立一个接收端的港口，用来接收数据，也就是Socket服务：DatagramSocket对象
     * 2、创建数据包，用于存储接收到的数据，方便用数据包的对象方法解析数据
     * 3、使用Socket服务对象recive()接收数据包
     * 4、通过数据包的解析方法解析数据
     * 5、关闭Socket服务
     * @param args
     */
     public static void main(String [] args) throws IOException {
         System.out.println("接收端启动");
        //1、和发送端一样，建立一个接收端的港口，用来接收数据，也就是Socket服务：DatagramSocket对象
         //注意：要明确接收的端口信息，类似于对讲机，必须在同一个频道上
         DatagramSocket ds = new DatagramSocket(9999);
         //2、创建数据包，用于存储接收到的数据，方便用数据包的对象方法解析数据，这里字节数组有些问题，长度不应该限制
         byte [] buf = new byte[1024];
         DatagramPacket dp = new DatagramPacket(buf,buf.length);//用来接收长度为length的数据包
        //3、使用Socket服务对象recive()接收数据包
         ds.receive(dp);  // 阻塞式方法，接收到数据之后继续运行
        //4、通过数据包的解析方法解析数据
         String ip = dp.getAddress().getHostAddress();
         int port = dp.getPort();
         String text = new String(dp.getData());
         System.out.println(ip+":"+port+"接收到的数据为："+text);
         //5、关闭Socket服务
         ds.close();
     }
}
