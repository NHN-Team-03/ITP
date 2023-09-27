package example;

import example.OuterClass.InnerClass;

public class Main {
    public static void main(String[] args) {
        FunctionR2R[] multipliers = new FunctionR2R[100];
        for (int i = 0; i < 100; i++) {
            int n = i;
            multipliers[i] = z -> n * z;
            System.out.println(multipliers[i].valueAt(1));
        }
    }
}

interface FunctionR2R {
    double valueAt(double x);
}