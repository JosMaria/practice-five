package org.genesiscode.practicefive.model;

import org.genesiscode.practicefive.model.util.Decimal;
import org.genesiscode.practicefive.model.util.MyFunction;

import java.util.Random;

public class ReachMethod {

    private static final Random random = new Random();
    private static final double LIMIT = 1.0;
    private double r1, r2;
    private MyFunction myFunction, myFunction2;

    public double getR1() {
        return Decimal.getDecimal(2, r1);
    }

    public double getR2() {
        return Decimal.getDecimal(2, r2);
    }

    private double valueA, valueB, valueM;

    public static void main(String[] args) {
        ReachMethod reachMethod = new ReachMethod(4, 6, (double) 3 / 4,
                new MyFunction( Decimal.getDecimal(2, (double) 11/4),
                                Decimal.getDecimal(2, (double) 1/2)),
                new MyFunction( Decimal.getDecimal(2, (double) 9/4),
                                Decimal.getDecimal(2, (double) 1/2)));
        reachMethod.loadNumberRandoms();
        System.out.println(reachMethod.getR1());
        System.out.println(reachMethod.getR2());
        reachMethod.start();
        System.out.println(reachMethod.getR1());
        System.out.println(reachMethod.getR2());

    }

    public ReachMethod(double valueA, double valueB, double valueM,
                       MyFunction myFunction1, MyFunction myFunction2) {
        this.valueA = valueA;
        this.valueB = valueB;
        this.valueM = valueM;
        this.myFunction = myFunction1;
        this.myFunction2 = myFunction2;
    }

    private void loadNumberRandoms() {
        r1 = Decimal.getDecimal(2, random.nextDouble(LIMIT));
        r2 = Decimal.getDecimal(2, random.nextDouble(LIMIT));
    }

    public void start() {
        loadNumberRandoms();
        System.out.println("R1: " + r1);
        System.out.println("R2: " + r2);
        double x = valueA + ((valueB - valueA) * r1);
        double value1 = (myFunction.getMultiplicativeX() * x) + myFunction.getConstant();
        double value2 = (myFunction2.getMultiplicativeX() * x) + myFunction2.getConstant();
        double value = selectNumber(value1, value2);
        r1 = value * (1 / valueM);
    }

    public double selectNumber(double number1, double number2) {
        return Math.max(number1, number2);
    }
}
