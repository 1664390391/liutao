package datastrucre.advancedsort;

/**
 * 测试希尔排序，从小到大，使用n-增量排序加大间隔，或者元素的比较幅度。
 * 思路：1、根据数据的最大量测试希尔排序的n的增量最大值。
 * 2、定义外部变量和内部变量，然后定义一个临时变量
 * 外部的变量从h开始比较，将外部变量对应的值放置在temp中临时存储
 * 使用while循环比较，并且外部变量不能大于数组最大值，递增
 * 当内部的变量比外部的大，那么调换位置，否则保持不变，整个一轮循环完之后，继续减少h的值，继续比较
 *
 *
 *
 */
class MyShellSort{
    private int [] arr;
    private int nElmes;
    //初始化数组的大小
    MyShellSort(int size){
        arr = new int [size];
        nElmes = 0;
    }

    public void insert(int val){
        arr[nElmes] = val;
        nElmes++;
    }

    public void show(){
        System.out.print("数组：");
        for(int i = 0;i<nElmes;i++){
            System.out.print(arr[i]+"、");
        }
        System.out.println();
    }

    public void shellSort(){
        //定义两个变量，和存储临时的数据
        int out,in,temp;
        //设置最大的增量
        int h = 1;
        h=h*3+1;

        //进行while循环，进行排序
        //先判断h的合法性
        while(h>0){
            System.out.println("h为"+h);
            //从外部索引开始循环，不能超出数组长度
            for(out = h;out <nElmes;out++){
                //将外部索引当前的数组存储到临时数据中来
                temp = arr[out];
                //不理解1：为什么将外部索引赋值给内部（插入排序的复杂化，由in--编程in-=h）
                in = out;
                //out角标必须从n增量的下一个开始，判断角标的合法性,如果n增量前的数据大于后面的，那么交换，否则不动
                while(in > h-1 && arr[in-h]>=temp){
                    System.out.println("将"+arr[in]+"替换成"+arr[in-h]);
                    arr[in] = arr[in-h];
                    in -= h;
                }
                //如果没换，out赋值就是原来的值，如果换了，那么将out已经换成in了，in变为原来的out
                arr[in] = temp;
            }
            h=(h-1)/3;
        }
    }

    /**
     * 测试划分的方法
     * @param left
     * @param right
     * @param standard
     * @return
     */
    public int partition(int left ,int right,int standard){
        int leftptr = left -1;
        int rightptr = right +1;
        while(true){
            //当符合条件（发现数据确实大于标准值）的时候，while两个条件不完全成立leftptr对应的位置停下，退出循环
            while(leftptr < right && arr[++leftptr]<standard);
            //同理，小于标准值的时候停下。
            while(rightptr > left && arr[--rightptr] > standard);
            if (leftptr >= rightptr) {
                break;
            }
            else{
                System.out.println("leftptr："+leftptr+"和 rightptr："+rightptr+"交换了");
                swap(leftptr,rightptr);
            }
        }
        return leftptr;
    }

    public void swap(int l,int r){
        int temp = arr[l];
        arr[l]=arr[r];
        arr[r] = temp;
    }

    /**
     * 测试快速排序
     * 思路：利用划分的思想，将数据分成两个部分
     * 然后小数组继续利用划分的思想，继续分，直到最后数组为1的状态
     * 但是，划分的枢纽怎么选择呢？
     * 选择数组的最后一位作为枢纽，然后将对比完之后的数据最后一位和枢纽位置数据交换。重复操作即可
     */
    public void quickSort(){
        recQuickSort(0,nElmes-1);
    }

    private void recQuickSort(int left, int right) {
        //如果划分的左右下标已经相遇，那么就不要在继续操作了
        if(right-left<=0){
            return;
        }else{
            //将数组的最右段的值当做枢纽
            int pivot = arr[right];
//            System.out.println("枢纽值是："+pivot);
            //进行数组的划分
            int partition = quickSortPartition(left,right,pivot);
            System.out.println("从left："+left+"和right："+right+"分开，枢纽是："+pivot);
            //分别对左右数组进行递归的划分
            recQuickSort(left,partition-1);
            recQuickSort(partition+1,right);
        }
    }

    /**
     * 快速排序划分的方法，不同点在于从最右边倒数第二个开始，最后将枢纽位置得数据和枢纽本身（最后数据项）互换
     * @param left
     * @param right
     * @param standard
     * @return
     */
    public int quickSortPartition(int left ,int right,int standard){
        int leftptr = left -1;
        //不从right +1开始
        int rightptr = right;
        while(true){
            //当符合条件（发现数据确实大于标准值）的时候，while两个条件不完全成立leftptr对应的位置停下，退出循环
            while(leftptr < right && arr[++leftptr]<standard);
            //同理，小于标准值的时候停下。
            while(rightptr > left && arr[--rightptr] > standard);
            if (leftptr >= rightptr) {
                break;
            }
            else{
                System.out.println("leftptr："+leftptr+"和 rightptr："+rightptr+"交换了");
                swap(leftptr,rightptr);
            }
        }
        //最后将枢纽位置得数据和枢纽本身（最后数据项）互换
        swap(leftptr,right);
        return leftptr;
    }



}


public class ShellSort {
    public static void main(String [] args){
        MyShellSort s = new MyShellSort(10);
        s.insert(20);
        s.insert(12);

        s.insert(42);
        s.insert(23);
        s.insert(61);
        s.insert(23);
        s.insert(10);
        s.insert(2);
        s.show();
        s.quickSort();
        System.out.println();

        s.show();
    }
}
