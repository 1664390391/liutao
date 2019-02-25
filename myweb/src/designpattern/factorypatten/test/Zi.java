package designpattern.factorypatten.test;

public class Zi extends Fu {

    public void fu() {
        int i = 10;
        super.fu(i);
        System.out.println("zi run : "+i);
    }

     public static void main(String [] args){
        new Zi().fu();
     }
}
