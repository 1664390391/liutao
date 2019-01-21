package datastrucre.day2_LinkedStudy;

/**
 * Created by 16643 on 2018/5/26.
 */
public class TestLinked {
    public static void main(String [] args){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(11);
        linkedList.addFirst(22);
        linkedList.addFirst(33);
        System.out.print(linkedList.toString());
        //在2的位置上添加44
        linkedList.addByIndex(2,44);
        System.out.print(linkedList.toString());
    }
}
