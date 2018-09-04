package javase.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/4
 */
public class MapTest {
    public static void main(String [] args){
        test1();
    }

    /**
     * 打印一个字符串“klhfksahfksafadf”,获取该字符串中，每一个字母出现的次数
     *
     * 思路：
     * 根据问题分析可以发现：字母和次数之间存在的一些映射关系。
     * 而能存储映射关系的容器有两种：数组和map集合。
     * 那么这些映射关系一方的编号有序吗？ 没有有序编号！
     * 那么就可以使用map集合存放键值对
     * 又发现保证唯一性的一方具备着字母的顺序，a,b,c...
     * 那么可以选择treemap进行操作
     *
     * 怎么操作呢?
     * 详细操作思路：
     * 因为这个集合最终应该存储的是字母和出现次数的对应关系。
     * 1、因为操作的是字符串的字母，所以先将字符串转换成字符数组（注意：字母是26个英文字母，字符是包括字母，数字，符号等，toCharArray就是转成字符数组 ）
     * 2、将字符数组进行遍历。
     * 3、每取出一个元素都和已有的集合中的所有键进行比较，如果keyset的set集合中存在该key，那么值+1，使用key和新值进行保存，会覆盖原来的值
     *      否则没有该键，那么就保存该键值对，key , value = 1
     */
    public static void test1(){
        String str = "kllllhfksahfksasfasswqerqerqewrafadf";
        for(int i = 0;i<20;i++){
            str+=str;
        }
        long startTime1 =System.currentTimeMillis();
        Map<Character,Integer> map = new HashMap<>();
        //这段代码分别使用hashMap和treeMap测试多次
        //结论:如果需要key进行字母排序，那么肯定需要使用treeset，就是效率低了一些，大约是hashMap速度的1.5倍，如果没有强制要求key有序，还是hashMap快
        char [] chars = str.toCharArray();
        for (char c : chars){
//            Integer integer = map.get(c) != null ? map.put(c, map.get(c) + 1) : map.put(c, 1);
            int count = 0;
            Integer i = map.get(c);
            if(i != null){
                count = i + 1;
            }
            map.put(c,count);
            /*if(map.keySet().contains(c)){
                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }*/
        }
        System.out.println(map);
        long endTime1 =System.currentTimeMillis();
        System.out.println("的运行时间："+(endTime1-startTime1)+"ms");

    }

}
