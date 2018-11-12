package javase.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟一个浏览器请求
 */
public class SimulateBrowser {
    public static void main(String [] args) throws IOException {
        //创建一个服务，使用Socket流模拟浏览器的http请求,这里访问本地的tomcat
        Socket socket = new Socket("127.0.0.1",8088);
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println("GET / HTTP/1.1");
        out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        out.println("Cache-Control: max-age=0");
        out.println("Connection: keep-alive");
//        out.println("Cookie: acw_tc=7b39758215417553176208597e714d4137447a302a5be518a43bfc053f008; ASP.NET_SessionId=2ruestlrm4jbisteel4hpi1w");
        out.println("Host: 127.0.0.1:8088");
//        out.println("Upgrade-Insecure-Requests: 1");
//        out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
        out.println();
        out.println();
        //接收响应
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String text = null;
//        System.out.println(text);

//        int len = 0;
//        System.out.println(new String(buf,0,len));
        while((text = in.readLine())!=null){
            System.out.println(text);
        }


        socket.close();
        /*
        for(int j = 0; j < 20 ; j ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ; i < 300 ; i ++){
                        try{
                            //创建一个服务，使用Socket流模拟浏览器的http请求
                            ...
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }

        */


    }
}
