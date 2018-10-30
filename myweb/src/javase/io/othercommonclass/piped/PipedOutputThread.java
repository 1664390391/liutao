package javase.io.othercommonclass.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * details:一个管道输出流的线程
 *
 * @author lt
 * @date 2018/10/30
 */
public class PipedOutputThread implements Runnable {
    private PipedOutputStream pos;

    public PipedOutputThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
//            pos.write("我是管道输出流，我先睡一会，输入流的弟弟还得等我~".getBytes());
            Thread.sleep(5000);
            pos.write("我是管道输出流，我先输出出来再给链接我输入流线程的弟弟们使用!".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
