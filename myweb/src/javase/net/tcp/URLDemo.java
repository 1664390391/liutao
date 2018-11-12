package javase.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 演示URL类的相关使用
 * URL就是封装Socket+具体协议解析的对象，直接输入连接路径即可获取连接对象
 * 直接使用该对象传入请求地址即可进行模拟请求，并进行网络传输
 */
public class URLDemo {
     public static void main(String [] args) throws IOException {
//         String url_str = "http://127.0.0.1:8088";
         String url_str = "http://www.baidu.com:80";
         URL url = new URL(url_str);
         //通过url对象得到一些基本信息
         System.out.println("请求协议："+url.getProtocol());
         System.out.println("请求主机："+url.getHost());
         System.out.println("请求端口："+url.getPort());
         System.out.println("请求文件（路径+查询数据）"+url.getFile());
         System.out.println("请求路径"+url.getPath());
         System.out.println("查询数据"+url.getQuery());

         //获取url对象的URL连接器对象，将连接封装成了对象：即java中内置可以解析具体的协议对象+socket
         //sun.net.www.protocol.http.HttpURLConnection:http://127.0.0.1:8088/index
         //根据请求的路径，得到请求协议，然后找到相关的协议处理器，得到URLConnection的子类HttpURLConnection
         URLConnection conn = url.openConnection();
         System.out.println(conn);
         //得到一个解析http请求之后的输入流，获取返回的响应消息体,如果使用socket接收的输入流是得到响应全部信息
         //其实 InputStream in =  url.openStream() 就是url.openConnection().getInputStream()
         //即打开URL连接并返回一个用于从该链接读入的InputStream
         InputStream in = conn.getInputStream();
         BufferedReader bufIn = new BufferedReader(new InputStreamReader(in));
         String text = null;
         while((text = bufIn.readLine())!=null){
             System.out.println(text);
         }
         bufIn.close();










     }
}
