package javase.stringstudy;

/**
 * 测试正则表达式
 * Created by 16643 on 2018/8/29.
 */
public class RegixDemo {
    public static void main(String [] args){
//        TestMatch();
//        TestSplit();
//        TestReplace();
        System.out.println("\\");
    }

    /**
     * 测试替换。使用repalceAll
     * $1 中 $表示前一个正则中的组，1表示第一组
     */
    private static void TestReplace() {
        String regix = "(\\d{3})\\d{4}(\\d{4})";
        String  tel = "13422221111";
        System.out.println(tel.replaceAll(regix,"$1****$2"));

    }

    /**
     * 测试切割
     */
    private static void TestSplit() {
        String str1 = "zhangsan.lisi.wangwu";
        //使用转义之后的.进行切割    单个.表示任意，"\."表示转义之后的字符串.
        String regix1 = "\\.";
        String [] names = str1.split(regix1);
        for (String name : names) {
            System.out.println(name);
        }

        //使用组的概念，使用连续出现1次以上的任意字符进行分割,这里1是第一组，+表示出现一次以上
        String str2 = "zhangsanbblisikkkwangwu";
        String regix2 = "(.)\\1+";
        String [] names2 = str2.split(regix2);
        for (String name : names2) {
            System.out.println(name);
        }
    }

    /**
     * 验证手机号
     * 第一位必须是1，用正常数字1
     * 第二位必须是3,5,8，用[358]整体表示第一位
     * 后面九位随机数据，可以使[0-9]，也可以简化为\d,并{9}
     */
    private static void TestMatch() {
        String  tel = "13422221111";
        String regix = "1[358]\\d{9}";
        System.out.println(tel.matches(regix));
    }
}
