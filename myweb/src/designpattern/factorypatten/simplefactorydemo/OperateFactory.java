package designpattern.factorypatten.simplefactorydemo;

/**
 * 简单工厂测试类，通过不同的运算符提供不同类的对象以供使用
 * 这里只是写了两个，如果有更多也可以继续写
 * Created by 16643 on 2019/2/17.
 */
public class OperateFactory {
    public static Operate createOperate(String operate){
        //可以使用switch，也可以使用ifelse，这里简单写了
        if("+".equals(operate)){
            return new OperateAdd();
        }else if("*".equals(operate)){
            return new OperateMul();
        }else {
            System.out.println("没有该类运算符的类对象");
            return null;
        }
    }
}
