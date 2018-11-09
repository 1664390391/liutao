package javase.net.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟一个浏览器请求
 */
public class SimulateBrowser {
    public static void main(String [] args) throws IOException {
        for(int j = 0; j < 20 ; j ++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ; i < 300 ; i ++){
                        try{
                            Socket socket = new Socket("www.elian.net",80);
                            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
                            out.println("GET /Login/Index HTTP/1.1");
                            out.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
                            out.println("Cache-Control: max-age=0");
                            out.println("Connection: keep-alive");
                            out.println("Cookie: acw_tc=7b39758215417553176208597e714d4137447a302a5be518a43bfc053f008"+i+"; ASP.NET_SessionId=2ruestlrm4jbisteel4hpi1w");
                            out.println("Host: www.elian.net");
                            out.println("Referer: http://www.elian.net/");
                            out.println("Upgrade-Insecure-Requests: 1");
                            out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
                            out.println();
                            out.println();
                            //接收响应
                            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                            String text =  in.readLine();
                            System.out.println(text);
                            //        byte [] buf = new byte[10240];
                            //        int len = in.read(buf);
                            //        System.out.println(new String(buf,0,len));
                            socket.close();
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }


    }
}
