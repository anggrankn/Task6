package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readValues("x");
        double N = readValues("N");
        double e = readValues("e");

        double sumOfSequence = getSumOfSequence(x, N);
        printResult("Sum of n terms of the given sequence", sumOfSequence);

        double sumOfSequenceWithEpsilon = getSumOfSequenceWithEpsilon(x, N, e);
        printResult("The sum of terms that are greater than e in absolute value", sumOfSequenceWithEpsilon);

        double sumOfSequenceWithEpsilonDividedTen = getSumOfSequenceWithEpsilon(x, N, e / 10);
        printResult("The sum of terms that are greater than e/10 in absolute value", sumOfSequenceWithEpsilonDividedTen);

        double valueOfFunction = getValueOfFunction(x);
        printResult("Function value", valueOfFunction);
    }

    public static double readValues(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter %s: ", name);
        return scanner.nextDouble();
    }

    public static void printResult(String phrase, double result) {
        System.out.printf("%s = %f\n", phrase, result);
    }

    public static double getNMemberOfSequence(double x, double n) {
        return Math.pow(-1, n) * Math.pow(x, n);
    }

    public static double getSumOfSequence(double x, double N) {
        double Sum = 0;
        for (int i = 0; i <= N; i ++) {
            Sum += getNMemberOfSequence(x, i);
        }
        return Sum;
    }

    public static double getSumOfSequenceWithEpsilon(double x, double N, double e) {
        double Sum = 0;
        for (int i = 0; i <= N; i ++) {
            if (getNMemberOfSequence(x, i) > e) {
                Sum += getNMemberOfSequence(x, i);
            }
        }
        return Sum;
    }

    public static double getValueOfFunction(double x) {
        return 1 / (1 + x);
    }
}
