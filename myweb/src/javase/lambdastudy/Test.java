package javase.lambdastudy;


import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by lt on 2018/7/31.
 * Function :
 * Params :
 * Return :
 */
public class Test {
    public static void main(String [] args){
//        Map<String, String> map = new HashMap<>();
//        if(1 == 1){
//            map.put("aa","111");
//        }
//        System.out.println(map.size());
//        System.out.println(strIsInt("-111"));
//        System.out.println(strIsInt("11.33"));
//        String s = getNextElementById("getCommunityId");


//        HashMap<String,String> map = new HashMap<>();
//        map.put("addressNames","大大");
//        map.put("updateNum","111");
      /*  Map numberAndCount = new HashMap<>();
        Integer[] numbers = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        for(Integer i : numbers){
            Integer count = (Integer) numberAndCount.get(i);
            System.out.println("count"+count);
            numberAndCount.put(i, count++); // NullPointerException
        }*/
//        String s = String.valueOf(123);
//        System.out.println(s.getClass());

        int a = 3,b = 5;
        //a 通过位运算得到异或之后的值
        a = a ^ b;
        //这里b = a ^ b  ^ b --> a，一个数异或两次同一个数，得到的还是原来的数
        b = a ^ b;
        //这里a = a ^ b ^ a  -->  这里的b就是之前的a，也就想当于 a ^ b ^ a --> b
        a = a ^ b;
        //下面实例通过算术运算和上面的同理
        a = a+b;
        b = a-b;
        a = a-b;


    }


    /**
     * 判断字符串是否为整数数字
     * @param str
     * @return
     */
    public static boolean strIsInt(String str){
        if (str == null || "".equals(str)){
            return false;
        }
        return Pattern.compile("^-?[1-9]\\d*$").matcher(str).find();
    }

    public static int add(int i){
        i+=1;
        return i;
    }


    public static String getNextElementById(String column) {
        List<String> list = new ArrayList<>();
        list.add("getCommunityId");
        list.add("getVillageCommunityId");
        list.add("getStreetId");
        list.add("getHousingEstateId");
        list.add("getNaturalVillageId");
        list.add("getGroupId");
        list.add("getHouseNumberId");
        list.add("getBuildingId");
        list.add("getUnitId");
        list.add("getRoomId");
        int index   = 0;
        for (String s : list) {
            index++;
            //如果找到匹配的项，那么就
            if(column.equals(s)){
                List<String > subList = list.subList(index,list.size());
                System.out.println(subList.size());
                for (String s1 : subList) {
                    System.out.println(s1);
                }
            }
        }
        return null;
    }


}
