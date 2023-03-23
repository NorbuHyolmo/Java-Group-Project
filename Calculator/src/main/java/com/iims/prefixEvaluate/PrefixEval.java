package com.iims.prefixEvaluate;

import java.util.Stack;

public class PrefixEval {
    static Stack<Double> store = new Stack<>();

    static Boolean Operand(char numOper) {
        return numOper >= 48 && numOper <= 57;
    }

    static void calculate(Double num, Double numOne, String oper) {
        switch (oper) {
            case "+":
                store.push(num + numOne);
                break;
            case "-":
                store.push(num - numOne);
                break;
            case "*":
                store.push(num * numOne);
                break;
            case "/":
                store.push(num / numOne);
                break;
        }
    }

    public static double evaluatePrefix(String expression) {
        String[] numOperater = expression.split("\\s+");

        for (int i = numOperater.length - 1; i >= 0; i--) {
            if (Operand(numOperater[i].charAt(0)))
                store.push(Double.parseDouble(numOperater[i]));

            else {
                double numOne = store.pop();
                double numTwo = store.pop();

                calculate(numOne, numTwo, numOperater[i]);
            }
        }

        return store.peek();
    }
}
