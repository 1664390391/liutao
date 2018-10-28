package javase.io.filestudy;

import java.io.*;

/**
 * Created by 16643 on 2018/10/24.
 */
public class Test {
    public static void main(String [] args) throws IOException {

        BinaryFile.write("testWriter.txt","aaaaa");
    }
}

class BinaryFile{
    public static byte[] read(File file) throws IOException {
        BufferedInputStream bif =new BufferedInputStream(
                new FileInputStream(new File("D:\\idea-workspace\\liutao\\test.bin")));
        try{
            byte [] data = new byte[bif.available()];
            bif.read(data);
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bif.close();
        }

        return null;
    }

    public static void write(String filename ,String text){
        try {
            PrintWriter pw = new PrintWriter(new File(filename).getAbsoluteFile());
            pw.print(text);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
