package com.netjava;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Stack;

@WebServlet(name = "/LoginServlet", value = "/LoginServlet")
public class InputBracketServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String userInput = request.getParameter("inputHere");
            response.getWriter().println(checkBrackets(userInput));
    }
    public static String checkBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        //tocharArray converts the string into character array
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                //stack.peek() retrieves or fetches the first element of the stack or top element
                if (c == ')' && stack.peek() != '(') {
                    return "NO";
                } else if (c == '}' && stack.peek() != '{') {
                    return "NO";
                } else if (c == ']' && stack.peek() != '[') {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }
}
