package javase.io.othercommonclass.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * details:测试管道流联合多线程的简单使用
 * 管道输入流创建必须连接一个管道输出流，然后读取输出流中的数据，
 * 不建议使用单线程因为容易挂掉，使用多线程实现管道流的读写即可，用处暂未明白，写个demo玩一玩先
 * @author lt
 * @date 2018/10/30
 */
public class PipedDemo {
    public static void main(String [] args) throws IOException {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        //将两个流链接起来
        pis.connect(pos);
        new Thread(new PipedInputThread(pis)).start();
        new Thread(new PipedOutputThread(pos)).start();

    }
}
