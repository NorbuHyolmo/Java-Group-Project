package com.iims.controller;

import com.iims.infixPrefix.InfixPrefix;
import com.iims.prefixEvaluate.PrefixEval;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculation", urlPatterns = "/calculation")
public class calculation extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String expression = req.getParameter("expression");
        String preExpression = InfixPrefix.infixToPrefix(" " + expression);
        System.out.println(preExpression);
        double output = PrefixEval.evaluatePrefix(preExpression);
        System.out.println(output);


        resp.setContentType("text/html");
        resp.getWriter().write("{ \"output\": \"" + output + "\" }");
    }
}
