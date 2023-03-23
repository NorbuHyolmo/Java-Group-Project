package com.netjava;


import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String U_username = request.getParameter("uname");
        String U_password = request.getParameter("password");

        try{
            PrintWriter out = response.getWriter();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_application","root","");
            PreparedStatement stm = conn.prepareStatement("Select * from login where username=? and password=?");
            stm.setString(1,U_username);
            stm.setString(2,U_password);
            ResultSet rs = stm.executeQuery();

            if(rs.next()) {
                  out.println("<p> Username :</p>" + rs.getString(3));
                  out.println("<p> Password :</p>" + rs.getString(4));
            }else{
                out.println("<p font color = 18 size = 18 align=center> Login Failed!<br> </p>");
                out.println("<div align =center><a href= index.jsp align=center>Try Again </a></div>");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
