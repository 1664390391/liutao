package datastrucre.day2_LinkedStudy;

/**
 * 测试链表结构
 */
public class MyLinkedList<E> {

    /**
     * 建立节点类，用来关联链表
     */
    private class Node{
        //元素、下一个节点
        public E e;
        public Node next;

        //基本构造方法
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    //链表的私有化字段，长度和当前节点
    //设置虚拟节点，默认空的链表有第一个元素
    private Node dummyHead;
    private int size;

    /**
     * 初始构造函数，值和长度都是null
     */
    public MyLinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }



    /**
     * 练习使用，根据索引添加新元素，开发中很少使用
     * 思路：将插入位置的前一个元素找到， 他指向的节点位置换成当前元素的下一个节点位置，
     * 然后改元素的位置变成上一个元素的下一个位置
     */
    public void addByIndex(int index,E e){
        //小于0，错误，大于元素长度，也就是添加到最末尾，不需要index >= size，因为如果循环到size，就是添加最后一个
        if(index < 0 || index > size){
            throw  new RuntimeException();
        }

//      //该元素是第一个元素，所以下面遍历的时候，index-1，因为初始位置就是0号位了
//      Node prev = head;
        //默认前一位元素是虚拟节点，这时候下面就从0遍历到index位置了
        Node prev = dummyHead;
        //找到插入位置前一个元素
        for(int i = 0;i<index;i++){
            prev = prev.next;

        }
        prev.next = new Node(e,prev.next);
        size++;

    }

    //在头部添加新元素,将上一个元素的节点地址关联上，然后将本元素的地址抛出来
    public void addFirst(E e){
//        head = new Node(e,head);
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        size++;

        //如果从addFisrt角度来看，默认一个虚拟的头结点，然后每次都将虚拟头结点的下一级指向本元素e，
        // 然后原来保存的下一个元素地址被放到本元素新建的node的下一级中去了。
        addByIndex(0,e);
    }

    public void addLast(E e){
        addByIndex(size,e);
    }

    public E getByIndex(int index){
        //判断元素的合法性
        if(index < 0 || index >= size){
            throw  new RuntimeException();
        }
        //获得虚拟子节点的下一个元素地址
        Node cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            //循环，将下一个元素
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return getByIndex(0);
    }
    public E getLast(){
        return getByIndex(size-1);
    }

    /**
     *  -- 刘涛的错误思路：这里根据索引更新需要将当前位置上的元素e更新掉就可以了，不需要找上下关系之类的，因为不需要重新new对象
     * 练习：根据索引，以及元素，更新位置上为新元素
     * 思路：1、先判断索引的合法性
     * 2、将位置上元素找到，将其存入的地址记录下来，以及上一个元素也找到，记录地址
     * 3、本元素替换掉：将上个一元素地址指向新元素，新元素下一个地址换成旧元素的地址
     */
    public void oldUpdateByIndex(int index,E e){
        //判断元素的合法性
        if(index < 0 || index >= size){
            throw  new RuntimeException();
        }
        //上元素指向的当前元素地址
        Node pretemp = dummyHead.next;
        //当前元素下一个元素地址
        Node nexttemp = dummyHead.next.next;
        Node cur = new Node(e);
        if(index==0){
            //如果是第一个元素，那么虚拟节点指向新元素，新元素地址指向下一个元素
            pretemp.next = cur;
            cur.next = nexttemp;
        }else{
            //将上一个元素的地址和当前元素的指向的地址保存下来
            for(int i = 1;i<index;i++){
                //如果是最后一个元素，那么下一个节点为null，上一个节点指向
                if(i == index-1){
                    pretemp = pretemp.next;
                    nexttemp = null;
                }else{
                    pretemp = pretemp.next;
                    nexttemp = nexttemp.next;
                }
            }
            pretemp.next = cur;
            cur.next = nexttemp;
        }
    }

    public void updateByIndex(int index,E e){
        //判断元素的合法性
        if(index < 0 || index >= size){
            throw  new RuntimeException();
        }
        //设置当前位置为虚拟头结点
        Node cur = dummyHead.next;
        //循环遍历，找到当前元素的位置
        for(int i = 0 ; i< index;i++){
            cur = cur.next;
        }
        //将当前位置得元素赋值。
        cur.e = e;
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        //设置当前位置为虚拟头结点
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e+"-->");
            System.out.println("temp e  = "+cur.e);
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }


}
