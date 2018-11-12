package javase.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议服务器端演示
 */
public class TCPServerDemo {
    /**
     *  模拟TCP服务器端的操作
     *  1、创建服务器端的Socket服务，也就是ServerSocket对象
     *      服务器端必须确定一个端口，供客户端连接。
     *  2、获取连接过来的客户端对象，也就是Socket流
     *  3、通过客户端Socket对象中的输入流，读取到客户端发送过来的数据，并展示
     *  4、接收到数据之后，可以使用输出流向客户端响应一些数据，客户端会用输入流接收
     *  5、关闭客户端（服务器端一般不关闭）
     *  注意：明确端口，否则客户端连接不到，第二个是用完之后必须断开客户端连接，节省服务端的资源。
     *
     * @param args
     */
     public static void main(String [] args) throws IOException {
         ServerSocket ss = new ServerSocket(10001);
         Socket s = ss.accept(); //阻塞式方法，等待客户端的连接
         String clientIp = s.getInetAddress().getHostAddress();
         InputStream is = s.getInputStream();
         byte [] buf = new byte[1024];
         int len = is.read(buf);
         //循环导致Socket流挂了，这里目前只是接收一次
//         int len = 0;
//         while ((len = is.read(buf))!= -1){
             System.out.println("客户端："+clientIp+"发送数据："+new String(buf,0,len));
//         }
         //接收到数据之后，使用输出流向客户端响应一些数据
         OutputStream out = s.getOutputStream();
         out.write("服务器已收到".getBytes());
         s.close();
         //由于这里只使用一次，所以服务器也关闭了
//         ss.close();
     }
}
