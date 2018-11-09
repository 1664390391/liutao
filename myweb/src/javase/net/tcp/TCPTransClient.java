package javase.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟转换数据的客户端
 */
public class TCPTransClient {
    /**
     * 需求：读取键盘录入的字符，然后发送到转换字符的服务器，再接收服务器处理之后的响应数据，并展示
     * 思路：
     * 1、首先，要有客户端的端点:Socket对象，并明确要访问的服务位置
     * 2、明确客户端的源和目的
     *      源：键盘录入
     *      目的：Socket流的输出流。
     * 3、明确 TCP 整个Socket流的源和目的
     *      源：Socket流的输入流（服务器响应的数据）
     *      目的：客户端展示的位置。这里是控制台。也可以是客户端接收到数据的保存位置等等
     * 由于。操作的都是字符数据，可以考虑使用字符流
     * 4、关闭流
     * @param args
     */
     public static void main(String [] args) throws IOException {
         Socket socket = new Socket("127.0.0.1",10002);
         //客户端本身的源和目的
         BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
         //由于需要直接将原始的格式直接输出，所以不需要转换成字节流在操作，直接使用字符流+保持格式：PrintWriter
         PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
         //明确传输中的源(socket.getInputStream()，服务器的响应数据)和目的(控制台)
         BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter pw = new PrintWriter(System.out,true);
         String line;
         while((line = bufr.readLine())!= null){
             if("over".equals(line)){
                 break;
             }
             //使用socket.getOutputStream()发送数据到服务器,即客户端的目的
             out.println(line);
             //服务器接收之后使用输入流接收。并输出端奥控制台上
             String upperStr = bufIn.readLine();
             pw.println(upperStr);
         }
         //关闭Socket自己的流（out、bufIn），pw、bufr 使用的是系统的流，不需要关闭
         socket.close();
     }
}
