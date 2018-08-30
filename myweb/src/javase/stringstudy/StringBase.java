package javase.stringstudy;

import java.util.Date;

/**
 * details:
 *
 * @author lt
 * @date 2018/8/27
 */
public class StringBase {
    public static void main(String [] args){
//        String s2 = String.format("%1$tY-%1$tm-%1$td", new Date());
//        System.out.println(s2);

//        String s = new String("abc");
//        String s1 = s.intern();
//        System.out.println(s1);

//        System.out.println(Boolean.parseBoolean("true"));
//
//        Integer i = new Integer("111");
//        System.out.println(i.intValue());

//        int c = (int)'a';
//        System.out.println((char)(c-32));

        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2); // true
        System.out.println(i1.equals(i2)); // true
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);  // false
        System.out.println(i3.equals(i4)); // true

    }
}
