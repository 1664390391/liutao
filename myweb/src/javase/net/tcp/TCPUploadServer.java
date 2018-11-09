package javase.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟TCP上传的服务端
 */
public class TCPUploadServer {
    /**
     * 需求：接收客户端上传的文件，保存到服务器指定位置，结束之后响应数据：上传完成
     * 思路：
     * 1、创建服务器端的服务，并确定服务器的端口号
     * 2、得到链接进来的客户端的对象
     * 3、明确源和目的
     *      源：客户端的输入流
     *          是纯文本不？ 不一定，那么使用字节输入流
     *          需要额外功能不？需要，高效。使用缓冲区
     *      目的：服务器保存文件的位置
     * 4、返回响应的数据，同样明确目的和源
     * 5、关闭客户端服务
     * @param args
     */
    public static void main(String [] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        Socket s = ss.accept();
        InputStream in = s.getInputStream();
        OutputStream os = new FileOutputStream(".\\tcpUpload.png");
        System.out.println("服务器开始启动");
        byte [] buf = new byte[1024];
        int len = 0;
        while ((len = in.read(buf))!= -1){
            os.write(buf,0,len);
        }
        System.out.println("服务器上传文件完成，开始响应");
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        out.write("服务器上传完成");
        out.flush();
        s.close();
        ss.close();
    }
}
