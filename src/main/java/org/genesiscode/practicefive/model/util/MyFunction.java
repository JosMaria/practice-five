package org.genesiscode.practicefive.model.util;

public class MyFunction {

    private final double constant;
    private final double multiplicativeX;

    public MyFunction(double constant, double multiplicativeX) {
        this.constant = constant;
        this.multiplicativeX = multiplicativeX;
    }

    public double getConstant() {
        return constant;
    }

    public double getMultiplicativeX() {
        return multiplicativeX;
    }
}
