package javase.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收数据线程
 */
public class ReceiveThread implements Runnable{
    DatagramSocket ds;

    public ReceiveThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        //不断循环接收数据
        try {
            while(true){
                //2、创建数据包，用于存储接收到的数据，方便用数据包的对象方法解析数据，这里字节数组有些问题，长度不应该限制
                byte [] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf,buf.length);//用来接收长度为length的数据包
                //3、使用Socket服务对象recive()接收数据包
                ds.receive(dp);  // 阻塞式方法，接收到数据之后继续运行
                //4、通过数据包的解析方法解析数据
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                new String(dp.getData());
                String text = new String(dp.getData());
                System.out.println(ip+":"+port+"接收到的数据为："+text);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
