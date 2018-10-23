package javase.io.StreamStudy;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * details:模拟BufferedReader，实现BufferedReader中复写的read()和readLine()
 *
 * 分析：缓冲区无非就是一个封装的数组，并对外提供更多的方法对数组进行访问
 * 其实这些方法最终操作的都是数组的角标
 *
 * 缓冲的原理：其实就是从源中取出一批数据装进数组，再从数组中取出数据
 * 然后每次取数据的时候需要判断数组是否为空，如果为空则重新从源中读取一批新的数据，没有的话则返回-1
 *
 * 注意！！：既然MyBufferedReader是一个自定义的装饰类，那么应该是用Reader体系，并且操作的事Reader的对象的一些方法
 *
 * @author lt
 * @date 2018/10/16
 */
public class MyBufferedReader extends Reader{

    //缓冲区关联的字符流对象
    private Reader fr;

    public MyBufferedReader(Reader fr) {
        this.fr = fr;
    }

    //定义一个数组，用来存放缓冲区每次读取的数据
    private char [] buf = new char[1024];

    //定义一个数组的数量变量，记录每次操作之后的数组剩余数量
    private int count;

    //定义一个角标计数器，默认从0开始，每次取出数据都移动该角标计数器
    private int pos;

    /**
     * 模拟BufferedReader重写父类的read()
     * 其实同理，read(buf) 也是将用户创建好的数组传进来进行操作，可能相对很多判断要麻烦一些，具体代码需要细看源码
     * 需求：每次从缓冲区数组中读取一个数据。计数器自增一位，整体数量减少一位
     * 缓冲区中没有了，则从源中再读一批。并将读出来的数量重新计数，并归零指针
     * 如果源中也没有了，则返回-1
     * @return
     */
    public int myRead() throws IOException {
        //判断是否还有剩余的数据
        if(count == 0){
            count = fr.read(buf);
        }
        //如果源中也没有数据了，则返回-1
        if(count == -1){
            return count;
        }
        //读取单个数据,角标计数器后移一位，整体数量减少一位
        char ch = buf[pos++];
        count--;
        return ch;
    }

    public String myReadLine() throws IOException {
        StringBuilder sb = new StringBuilder();
        //使用缓冲区的read()在自己的数组中读取数据并存放到缓冲区中
        //不断的读写，直到数据为止，或者遇到/r/n换行符也可以返回一行数据
        int ch;
        while((ch = myRead())!= -1){
            if(ch == '\r'){
                continue;
            }
            if(ch == '\n'){
                return sb.toString();
            }
            sb.append((char) ch);
        }
        //如果文件最后没有换行，这时候缓冲区还有数据，但是文件已经读取完毕，需要判断并加以返回
        if(sb.length() != 0){
            return sb.toString();
        }
        return null;
    }

    /**
     *
     * @throws IOException 注意这个异常需要抛出，给用户知道，不能自己在方法中处理了
     */
    public void myClose() throws IOException {
        fr.close();
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        fr.close();
    }
}
