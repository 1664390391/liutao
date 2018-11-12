package javase.net.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 发送数据的线程
 */
public class SendThread implements Runnable {
    DatagramSocket ds;
    int sendPort;

    public SendThread(DatagramSocket ds, int sendPort) {
        this.ds = ds;
        this.sendPort = sendPort;
    }

    @Override
    public void run() {
        //接收键盘输入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        try {
            //无线循环进行发送，直到输入退出指令
            while((line = bufr.readLine()) != null){
                //创建字节数组，保存每次读取的数据，并存放到数据包中
                byte [] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),sendPort);
                //发送数据包
                ds.send(dp);
                if("over".equals(line)){
                    System.out.println("发送端关闭");
                    ds.close();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
