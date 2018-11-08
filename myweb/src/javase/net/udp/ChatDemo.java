package javase.net.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 模拟聊天程序
 */
public class ChatDemo {
     public static void main(String [] args) throws SocketException {
         int sendPort = 10000;
         DatagramSocket send = new DatagramSocket();
         DatagramSocket receive = new DatagramSocket(sendPort);
        new Thread(new SendThread(send,sendPort)).start();
        new Thread(new ReceiveThread(receive)).start();
     }
}
