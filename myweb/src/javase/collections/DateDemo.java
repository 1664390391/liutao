package javase.collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * details:时间类的例子
 *
 * @author lt
 * @date 2018/9/6
 */
public class DateDemo {
    public static void main(String [] args){
//        dateTest1();
//        dateTest2();
//        myDateToStr();
//        myStrToDate();
//        String date_str1 = "2018年9月6日";
//        String date_str2 = "2018年8月16日";
//        dateMinusTest(date_str1,date_str2);

        /*
        1.5之后为了更好地国际化，所以java使用的日期类从Date类升级为Calendar
         */
//        CalendarDemo();


        //小习题：传入一个year，判断其二月份是多少天
        int year = 2016;
        getFebDaysByYear(year);
        //小习题2：打印昨天的现在的时刻


    }

    /**
     * 传入一个year，判断其二月份是多少天
     * 思路：二月有多少天怎么求？
     * 不管有多少天，其三月1号都是固定的
     * 拿三月1号 - 1天，使用Calendar的add(int field, int amount)
     *  根据日历的规则，为给定的日历字段添加或减去指定的时间量。
     *  减去1，得到days
     *
     */
    private static void getFebDaysByYear(int year) {
        //得到一个Calendar对象
        Calendar c = Calendar.getInstance();
        //设置时间 xx 年 3月 1日
        c.set(year,2,1);
        //使用add方法修改时间
        c.add(Calendar.DAY_OF_MONTH,-1);
        showDate(c);
    }

    /**
     * 测试从Date类升级为Calendar类的用法
     */
    private static void showDate(Calendar c) {
        //得到一个Calendar对象
//        Calendar c = Calendar.getInstance();
//        System.out.println(c);//打印的是很多数据的键值对
        int year = c.getWeekYear();
        //注意月的用法比较特殊，1-12月0-11这几个角标决定的
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        //week也比较特殊，星期日是1，星期六是7，我们要转换一下
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("today is :"+year+"年"+month+"月"+day+"日"+hour+":"+minute+":"+second+getWeek(week));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));




    }

    private static String getWeek(int week) {
        String [] weekstr = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return  weekstr[week];
    }

    /**
     * 联系两个日期相减
     * 思路：两个日期相减，怎么减？
     * 需要将日期转换成毫秒值，然后相减。
     * 怎么转换成毫秒值？使用date对象，将一定格式的字符串转换成dateFormat的对象，转成date类型。然后在gettime
     * 得到的相减之后的毫秒值在转换成天数
     *
     *
     * @param date_str1
     * @param date_str2
     */
    private static void dateMinusTest(String date_str1, String date_str2) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");

        try {
            Date date1  = dateFormat.parse(date_str1);
            Date date2 = dateFormat.parse(date_str2);
            long l1 = date1.getTime();
            long l2 = date2.getTime();
            long l = l1 - l2;
            System.out.println("相差的毫秒值是："+l);
            //再将毫秒值转换为天数
            System.out.println("相差的天数是："+l/1000/60/60/24);


        } catch (ParseException e) {
            e.printStackTrace();
        }



    }

    /**
     * 将一定格式的字符串，转换成date对象
     */
    private static void myStrToDate() {
        String date_str = "2018-09-04 10:22:23";
//        DateFormat dateFormat = DateFormat.getDateInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(date_str);
            System.out.println(date);
            Long l = date.getTime();
            System.out.println(l);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void myDateToStr() {
        //        获取当前时间:Thu Sep 06 11:26:22 CST 2018
        Date date = new Date();
        //使用DateFormat类固定时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //使用format方法将时间格式化成自定义格式的字符串
        String datestr = dateFormat.format(date);
        System.out.println(datestr);
    }

    private static void dateTest2() {
//        获取当前时间
        Date date = new Date();
        System.out.println(date);
        //测试将日期对象进行格式化
        DateFormat dateFormat1 = DateFormat.getDateInstance();
        DateFormat dateFormat2 = DateFormat.getDateTimeInstance();
        String datestr1 = dateFormat1.format(date);
        String datestr2 = dateFormat2.format(date);
        System.out.println(datestr1);
        System.out.println(datestr2);


    }

    private static void dateTest1() {
        //获取当前时间的毫秒值
        long time = System.currentTimeMillis();
        System.out.println(time);//1536200734989

        //将毫秒值转换成日起对象
        Date date = new Date(1536200734989L);
        System.out.println(date);
    }


}
