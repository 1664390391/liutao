package javase.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟上传数据的服务端
 */
public class TCPUploadCilent {
    /**
     * 需求：将一个文件上传到指定端口的服务器中
     * 思路：
     * 1、创建客户端端口Socket，并且明确服务器
     * 2、确定客户端本身的源和目的
     *      源：一个文件
     *      是纯文本不？不一定，那么使用输出流
     *      需要额外功能不？需要，高效，那么使用缓冲区对象包装
     *      目的：服务器
     *  3、上传完成之后还需要接收客户端的响应（不然你咋知道服务器完全接收完了？）
     *      源：服务器端的响应输出流
     *      目的：客户端的控制台
     *  4、关闭客户端服务
     *
     * @param args
     */
    public static void main(String [] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10003);
        FileInputStream bis  = new FileInputStream(".\\萧美娘.png");
        OutputStream out = socket.getOutputStream();
        System.out.println("客户端开始发送。。");
        byte [] buf = new byte[1024];
        int len = 0;
        while ((len = bis.read(buf))!= -1){
            out.write(buf,0,len);
            //output 的 flush不执行任何操作，因为是自定义的缓冲区，如果使用缓冲区对象的话那么就要调用该方法
//            out.flush();
        }
        //结束之后发送结束文件上传结束标记
        socket.shutdownOutput();
        System.out.println("客户端发送结束。。");
        //接收服务器端的响应
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = bufIn.readLine();
        System.out.println("服务器响应："+response);

        //关闭相关的流
        bis.close();
        socket.close();

     }
}
