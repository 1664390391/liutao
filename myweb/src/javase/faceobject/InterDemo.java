package javase.faceobject;

/**
 * Created by 16643 on 2018/9/5.
 */

class InterTest{
    public final String first;
    public final Integer Second;

    public InterTest(String first, Integer second) {
        this.first = first;
        Second = second;
    }

    @Override
    public String toString() {
        return "Test{" +
                "first='" + first + '\'' +
                ", Second=" + Second +
                '}';
    }
}

public class InterDemo {
    public static void main(String [] args){
        InterTest interTest1 = new InterTest("aa",1);

        InterTest interTest2 = new InterTest("bb",2);
        System.out.println(interTest1.toString());
        System.out.println(interTest2.toString());
    }
}
