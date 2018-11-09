package javase.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟转换数据的服务端
 */
public class TCPTransServer {
    /**
     * 需求：读取客户端发送过来的数据，并转成大写响应回去
     * 1、创建客户端的服务端口，ServerSocket
     * 2、得到客户端的对象
     * 3、明确传输中的源和目的
     *      源：客户端发送过来的数据
     *          需要额外功能吗？
     *          需要，转换成字节流，操作纯文本
     *      目的：响应回客户端
     *  4、关闭客户端对象
     * @param args
     */
     public static void main(String [] args) throws IOException {
         ServerSocket ss = new ServerSocket(10002);
         Socket s = ss.accept();
         String ip = s.getInetAddress().getHostAddress();
         System.out.println(ip+"is connected...");
         //明确传输过程中的源和目的
         BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
         PrintWriter out = new PrintWriter(s.getOutputStream(),true);
         //不断的读取客户端发送过来的数据
         String line = null;
         while((line = bufIn.readLine())!=null){
             System.out.println("客户端发送的原始数据为："+line);
             out.println(line.toUpperCase());
         }
         s.close();
         ss.close();

     }
}
