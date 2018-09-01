package javase.faceobject;

/**
 * details:
 *
 * @author lt
 * @date 2018/9/1
 */
public class ExceptionTest {
    public static String output = "";
    public static void function(int i){
        try {
            if(i == 1){
                throw  new Exception();
            }
            output += "1";
        } catch (Exception e) {
            output += "2";
            return;
        }finally {
            output += "3";
        }
        output += "4";
    }

    public static void main(String [] args){
        function(0);
        System.out.println(output);
        function(1);
        System.out.println(output);
    }
}
