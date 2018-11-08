package javase.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 模拟TCP的客户端
 */
public class TCPClientDemo {
     public static void main(String [] args) throws IOException {
         /**
          * 使用TCP协议进行数据的传输，模拟客户端的相关操作
          * 思路：
          * 1、创建tcp客户端的Socket服务，使用的是Socket对象
          *     Socket：TCP用主机的ip加上主机的端口号作为TCP链接的端点，这个端点就是Socket，即 ip:port
          *     建议该对象一创建就明确需要访问的服务端目的地：即要链接的主机
          * 2、如果链接建立成功，说明数据传输通道已经建立。
          *     该通道就是Socket流，是底层建立好的，既然是流，说明该对象包含输入流、输出流。想要获取相关对象以及方法，可以通过Socket对象获取
          * 3、使用输出流，将数据写出（传输出去）
          *     为什么时候用输出流，因为这里是将本机的数据传输到网络上/服务器上
          * 4、使用输入流，接收服务器端响应的数据
          * 5、关闭流对象
          */

         Socket socket = new Socket("127.0.0.1",10001);
         OutputStream out = socket.getOutputStream();
         out.write("tcp演示客户端发送数据啦！".getBytes());
         //使用输入流接收服务器端响应的数据并展示
         InputStream is = socket.getInputStream();
         byte [] buf = new byte[1024];
         int len = is.read(buf);
         //循环导致Socket流挂了，这里目前只是接收一次
//         int len = 0;
//         while ((len = is.read(buf))!= -1){
             System.out.println("服务器返回数据："+new String(buf,0,len));
//         }
         socket.close();
     }
}
