package javase.io.othercommonclass;

import java.io.IOException;

/**
 * details:根据字符的个数截取字符串
 *
 * @author lt
 * @date 2018/10/31
 */
public class CutStringByBytes {
    public static void main(String [] args) throws IOException {
        String str = new String("nia你好797谢谢ss");

        for(int i = 0;i< str.getBytes("utf-8").length;i++){
            System.out.print("截取"+(i+1)+"个字节长度，得到的字符串是:");
            cutStringByU8(str,i+1);
        }

    }

    /**
     * 根据传入的字符串和要截取的长度，来截取可用的子字符
     * 思路：由于该字符串是中英文结合，英文占一个字符，中文的gbk占两个字符，
     *  并且中文在gbk中的对应的字节都是负数/一位负数+一位正数   （改功能还是可用的）
     * 所以，拿到截取之后的字节数组，倒序进行判断，最后的几个字节，如果没有负数或者负数个数为偶数，那么后面就可以正确的显示中文，单个负数就去掉最后一位字节即可
     * @param str
     * @param len
     */
    public static void cutStringByGBK(String str,int len) throws IOException {
        //1、将字符串解码出来
        byte [] buf = str.getBytes("gbk");
        //定义变量，得到最后几位负数的个数
        int count = 0;
        //在需要进行截取的位置加上判断,一旦读到正数的字节，就停止
        for(int i = len-1 ; i>=0;i--){
            if(buf[i] < 0){
                count++;
            }else{
                break;
            }
        }
        if(count % 2 == 0){
            System.out.println(new String(buf,0,len));
        }else {
            System.out.println(new String(buf, 0, len - 1));
        }

    }

    /**
     * u8解码字符串，如果是字母，那么是一位正数，如果是一个中文汉字，那么最后三位都是负数，得到要截取的位置往前计数负数的数量，不是3则舍弃
     * @param str
     * @param len
     * @throws IOException
     */
    public static void cutStringByU8(String str,int len) throws IOException {
        //1、将字符串解码出来
        byte [] buf = str.getBytes("utf-8");
        //定义变量，得到最后几位负数的个数
        int count = 0;
        //在需要进行截取的位置加上判断,一旦读到正数的字节，就停止
        for(int i = len-1 ; i>=0;i--){
            if(buf[i] < 0){
                count++;
            }else{
                break;
            }
        }
        if(count % 3 == 0){
            System.out.println(new String(buf,0,len,"utf-8"));
        }else if(count % 3 == 1) {
            System.out.println(new String(buf, 0, len - 1,"utf-8"));
        }else {
            System.out.println(new String(buf, 0, len - 2,"utf-8"));
        }

    }
}
