package javase.io;

import java.io.*;

/**
 * details:
 * 需求：1、测试键盘输入到控制台上
 * 2、测试键盘输入实时保存到系统文件中
 *
 * @author lt
 * @date 2018/10/22
 */
public class KeyboradInputDemo {
    public static void main(String [] args) throws IOException {
        //将键盘输入展示在控制台
//        KeyboradInputToConsole();
        //将键盘输入放到文件中
        KeyboradInputToFile();
    }


    /**
     * 键盘输入思路基本相同，就是保存到文件中
     * 没有优化，有点蠢
     */
    private static void KeyboradInputToFile() throws IOException {
        InputStream in = System.in;
        FileWriter fw = new FileWriter("testKeyboradInputToFile.txt",true);
        //定义变量，记录读取的字节码，以及字符串缓冲区
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while((ch = in.read()) != -1){
            //判断结束标记
            if(ch == '\r'){
                continue;
            }
            if(ch == '\n'){
                //判断输入的是否是over，是的话就结束，否则就输出之前出入的数据
                String temp = sb.toString();
                fw.write(temp+"\r\n");
                fw.flush();
                if("over".equals(temp)){
                    fw.close();
                    System.out.println("结束");
                    break;
                }
                System.out.println("已保存："+temp);
                //输出之后同时将缓冲区清空
                sb.delete(0,temp.length());
            }else{
                //不是换行符号，则将数据变成字符装进字符串缓冲区
                sb.append((char)ch);
            }

        }
    }

    /**
     * 目标：测试键盘输入到控制台上，每次回车才输出之前的所有输入数据
     * 思路：
     * 1、获得键盘的输入流System.in，该对象随着系统的加载而存在，随着系统的关闭而消失，不需要使用者自己去关闭
     * 2、由于操作的是字节流，这次测试的时字节数据，每次读到一个字节就保存下来，直到读到回车换行符\r\n
     * 3、将每次回车之前的数据保存下来，使用字符串缓冲区，待读取到回车标识，将其打印，并清空缓冲区
     */
    private static void KeyboradInputToConsole() throws IOException {
        InputStream in = System.in;
        //定义变量，记录读取的字节码，以及字符串缓冲区
        int ch = 0;
        StringBuilder sb = new StringBuilder();
        while((ch = in.read()) != -1){
            //判断结束标记
            if(ch == '\r'){
                continue;
            }
            if(ch == '\n'){
                //判断输入的是否是over，是的话就结束，否则就输出之前出入的数据
                String temp = sb.toString();
                if("over".equals(temp)){
                    break;
                }
                System.out.println(temp);
                //输出之后同时将缓冲区清空
                sb.delete(0,temp.length());
            }else{
                //不是换行符号，则将数据变成字符装进字符串缓冲区
                sb.append((char)ch);
            }

        }

    }
}
