package com.iims.infixPrefix;

import java.util.Stack;

public class InfixPrefix {
    static int preference(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPrefix(String expr){
        StringBuilder out = new StringBuilder();
        StringBuilder data = new StringBuilder(expr);
        Stack<Character> stack = new Stack<>();

        data.reverse();

        char [] expressChars = new String(data).toCharArray();

        for (int i = 0; i < expressChars.length; i++) {

            if (expressChars[i] == '(') {
                expressChars[i] = ')';
                i++;
            }
            else if (expressChars[i] == ')') {
                expressChars[i] = '(';
                i++;
            }
        }

        for (char ch : expressChars) {
            if (preference(ch) > 0) {
                while (!stack.isEmpty() && preference(stack.peek()) >= preference(ch))
                    out.append(stack.pop());

                stack.push(ch);
            } else if (ch == ')') {
                char x = stack.pop();

                while (x != '(') {
                    out.append(x);
                    x = stack.pop();
                }
            } else if (ch == '(')
                stack.push(ch);
            else
                out.append(ch);
        }

        for (int i = 0; i <=stack.size() ; i++)
            out.append(stack.pop());

        return out.reverse().toString();
    }
}

