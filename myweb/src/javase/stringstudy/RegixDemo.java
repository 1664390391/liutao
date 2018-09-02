package javase.stringstudy;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式
 * Created by 16643 on 2018/8/29.
 */
public class RegixDemo {
    public static void main(String [] args) throws Exception {
//        TestMatch();
//        TestSplit();
//        TestReplace();
//        System.out.println("\\");

//        test1();
        //邮箱的校验
//        checkEmailByRegix();

        //爬虫：一个用于在互联网中获取符合指定规则的数据小程序
//        List<String> list = testSpider();
        //打印输出，也可以保存到excel中，等等
//        for(String s : list){
//            System.out.println(s);
//        }

        //爬虫：一个用于在互联网中获取符合指定规则的数据小程序
//        List<String> list2 = testSpiderByWeb();
//        //打印输出，也可以保存到excel中，等等
//        for(String s : list2){
//            System.out.println(s);
//        }


//        int i= 0;
//        i = i++;
//        System.out.println(i);


    }

    /**
     * 爬虫网页数据
     * @return
     * @throws Exception
     */
    private static List<String> testSpiderByWeb()  throws Exception {


        //使用输入流缓冲区获取文件位置
//        BufferedReader bufr = new BufferedReader(new FileReader("D:"+ File.separator+"liutao"+ File.separator+"email.html"));
        URL url = new URL("https://zhidao.baidu.com/question/1772307510687057620.html");
        //url.openStream()：打开到此 URL 的连接并返回一个用于从该连接读入的 InputStream。然后使用输入流缓冲区读取
        BufferedReader bufr = new BufferedReader(new InputStreamReader(url.openStream()));
        // 将得到的输入流缓冲区进行正则的读取并存入数据
        List<String> list = dealDataWithRegix(bufr);
        return list;
    }

    private static List<String> dealDataWithRegix(BufferedReader bufr) throws IOException {
        //定义返回的集合
        List<String> list = new ArrayList<>();

        //对读取的数据进行规则的匹配，从中获取符合规则的数据
        String regix = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";

        //创建正则对象
        Pattern p = Pattern.compile(regix);

        //使用流得到数据
        String line = null;

        while ((line=bufr.readLine())!= null){
            //得到所有匹配的数据
            Matcher m = p.matcher(line);
            //将得到的数据存储到list集合中并返回
            while (m.find()){
                list.add(m.group());
            }
        }
        return list;
    }

    /**
     * 测试爬虫本地文件
     */
    private static List<String> testSpider() throws Exception {
        //使用输入流缓冲区获取文件位置
        BufferedReader bufr = new BufferedReader(new FileReader("D:"+ File.separator+"liutao"+ File.separator+"email.html"));
        // 将得到的输入流缓冲区进行正则的读取并存入数据
        List<String> list = dealDataWithRegix(bufr);
        return list;

    }

    /**
     * 使用正则校验邮箱
     * 首先，@  以及  . 不会变化
     * 然后前面的是任意字符，一次或者多次:[a-zA-Z0-9_]+
     * @ 之后的也是同理，就是没有_：[a-zA-Z0-9]+
     * . 之后一般出现是2-3位英文字母，所以是 [a-zA-Z]{2,3}，但是可能会出现多次，例如  xxx.com.cm
     *
     */
    private static void checkEmailByRegix() {
        String email  = "1664390391@qq.com";

        String regix = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";

        System.out.println(email + ":" + email.matches(regix));




    }

    /**
     * 治疗口吃
     * 分为两步，第一步去除‘.’
     * 第二步去除重复
     */
    private static void test1() {
        String str = "我...我我...我我爱...爱爱爱.....爱爱你....你..你你...你你";

        //   \\.+在正则中表示出现一次以上‘.’
        str = str.replaceAll("\\.+","");
        System.out.println("first:"+str);

        //第二步，去除重复，替换叠词
        str = str.replaceAll("(.)\\1+","$1");

        System.out.println("second:"+str);


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
