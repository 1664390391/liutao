package datastrucre.day2_LinkedStudy;

/**
 * Created by 16643 on 2018/5/26.
 */
public class TestLinked {
    public static void main(String [] args){
        LinkedListDemo<Integer> linkedListDemo = new LinkedListDemo<>();
        linkedListDemo.addFirst(11);
        linkedListDemo.addFirst(22);
        linkedListDemo.addFirst(33);
        System.out.print(linkedListDemo.toString());
        //在2的位置上添加44
        linkedListDemo.addByIndex(2,44);
        System.out.print(linkedListDemo.toString());
    }
}
