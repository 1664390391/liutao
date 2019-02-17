package designpattern.factorypatten.simplefactorydemo;

/**
 * 乘法子类
 * Created by 16643 on 2019/2/17.
 */
public class OperateMul extends Operate{
    @Override
    public double getResult() {
        double result = 0;
        result = numA * numB;
        return result;
    }
}
