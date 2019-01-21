import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.regex.Pattern;

public class test {
     public static void main(String [] args){
//         testMap();
//         new test().q1();

         int i = 5;
         int j = 7;
         System.out.println(i & j);

         // 00...00 1000-0000 使用char一个字节接收丢失精度
//         char ch  = 0X80;
//         System.out.println((byte)ch);   //-128
//         ch = 129;
//         System.out.println((byte)ch);   //-127

        /* int [] arr = new int[5];
         arr[0] = 0;
         arr[1] = 1;
         arr[2] = 2;
         for (int j = 0; j < arr.length; j++) {
             System.out.println("arr["+j+"] ="+arr[j]);
         }

         int [] arr1 = {31,32,33,34};
         for (int j = 0; j < arr1.length; j++) {
             System.out.println("arr1["+j+"] ="+arr1[j]);
         }*/
//         数组原理测试();


     }

    private static void 数组原理测试() {
        int i= 10;
        int [] arr1 = new int[i];
        for (int j = 0; j < arr1.length; j++) {
            System.out.println("arr1["+j+"] ="+arr1[j]);
        }


        int a = 3;
        int b = 5;
        //对于基本类型，互换没有用，在方法执行完之后内存就释放了，这里a、b都是值的副本传递，进入swap结束之后形参释放，原来的变量不收影响
//         emmm...也就是说，参数类型是原始类型，那么传过来的就是这个参数的一个副本，改变了副本中的值不会改变原值。
//        如果传递的是引用类型，那么传递的值就是地址的副本，但是两个地址一样。指向的是堆内存的对象也是同一个，操作时会改变地址对应堆内存中的对象信息。
        //  swap(a,b);
        System.out.println("a="+a+",b="+b);
    }

    private static void swap(int a, int b) {
         int temp ;
         temp = a;
         a = b;
         b = temp;
    }

    private void q1() {

        try {
            URL url = this.getClass().getClassLoader().getResource("");
            String filePath = "";
            String encodedUrl = url.getPath();
            filePath = URLDecoder.decode(encodedUrl, "UTF-8");
            filePath = filePath.substring(1, filePath.length());
            String c = filePath.substring(filePath.length()-1,filePath.length());
            filePath = filePath.substring(0, filePath.lastIndexOf(c));
            System.out.println(filePath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    private static void testMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("JLX_MC","丹北镇埤城环城路");
        map.put("DZXX_JDWDZB","2");
        map.put("SSXZJDDM","321181109");
        for(Map.Entry <String, Object> me : map.entrySet()){
            System.out.println(me.getKey()+":"+me.getValue());
        }
        Set<String > keys = map.keySet();
        Map<String, Object> map1 = new HashMap<>();
        for (String key : keys) {
            if(key.startsWith("DZXX_")){
                map1.put(key.replace("DZXX_",""),map.get(key));
            }else {
                if("JLX_MC".equals(key)){
                    map1.put(key,map.get(key));
                }else{
                    map1.put(key,map.get(key));
                }
            }
        }
        for(Map.Entry <String, Object> me : map1.entrySet()){
            System.out.println(me.getKey()+":"+me.getValue());
        }
    }
}
