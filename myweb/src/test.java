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
         String str = "111.1232111111";
         Pattern pattern = Pattern.compile("^[0-9]+([.]{1}[0-9]+){0,1}$");
         boolean b =  pattern.matcher(str).matches();
         System.out.println(b);

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
