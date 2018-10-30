package javase.io.othercommonclass.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * details:一个管道输入流的线程
 *
 * @author lt
 * @date 2018/10/30
 */
public class PipedInputThread implements Runnable {
    private PipedInputStream pis;

    public PipedInputThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        byte [] buf = new byte[1024];
        try {
            pis.read(buf);
            System.out.println(new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
