package datastrucre;

/**
 * 测试自定义的年内部链式存储机制
 * Created by 16643 on 2018/9/19.
 */
public class LinkedStack<T>{
    private static class Node<U>{
        U item;
        Node<U> next;
        public Node() {
            System.out.println(" Node() run");
            item = null;
            next = null;
        }
        public Node(U item, Node<U> next) {
            System.out.println(" Node(U item, Node<U> next) run");
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null && next == null;
        }
    }

    private Node<T> top  = new Node<>();

    public void push(T item){
        //每次创建新对象的时候将该对象地址留下，给下一个对象引用。
        //每一个对象的地址都是前一个对象，这样就构成了基本的栈结构，先进后出
        top = new Node<>(item,top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top = top.next;
        }
        return result;
    }
    public static void main(String [] args){
        LinkedStack<String> ls = new LinkedStack<>();
        for (String s : "aaa bbb ccc".split(" ")) {
            ls.push(s);
        }
        String s ;
        while ((s = ls.pop()) != null){
            System.out.println(s);
        }
    }

}
