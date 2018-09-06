package javase.stringstudy;

/**
 * Created by 16643 on 2018/8/28.
 */

class Demo{
    public void print(){
        System.out.println(this);
    }

}

public class StringDemo {
    public static void main(String [] args){
//        String str = "addfewrfadwead";
//        String key = "ad";
//
//        //查找子串出现的数量
//        int count = getSubstrCount(str,key);
//        System.out.println(count);
//        new Demo().print();
        String str = "aaa";
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

    /**
     * 需求：得到子串在字符串中出现的位置
     * 思路：1、获取key第一次出现的位置。使用indexOf方法
     * 2、得到之后继续在剩余的子串中进行寻找
     * 3、每次找到之后需要计数器记录一次，并且取得剩下的子串
     * 4、剩下的子串如何取？定义一个标签，记录每次出现的位置，然后+key的长度就是剩余所有的子串
     * 5、直到indexOf方法返回-1，证明已经没有key了
     *
     * @param str
     * @param key
     * @return
     */
    private static int getSubstrCount(String str, String key) {
        //定义计数器和key出现的位置
        int count = 0,index = 0;
//        while((index = str.indexOf(key)) != -1){
//            str = str.substring(index+key.length());
//            count++;
//        }
        while ((index = str.indexOf(key,index)) != -1){
            index = index+key.length();
            count++;
        }
        return count;
    }
}
