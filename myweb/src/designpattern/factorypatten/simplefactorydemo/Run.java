package designpattern.factorypatten.simplefactorydemo;

/**
 * Created by 16643 on 2019/2/17.
 */
public class Run {
    public static void main(String [] args){
        Operate oper = OperateFactory.createOperate("*");
        oper.numA = 2;
        oper.numB = 6;
        double result = oper.getResult();
        System.out.println("测试工厂结果：result = "+result);
    }
}
