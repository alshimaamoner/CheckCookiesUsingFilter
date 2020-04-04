
package com.mycompany.servletJsp;

import javax.servlet.*;
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;

/**
 *
 * @author Dell
 */
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in doGet");
        PrintWriter out;
        response.setContentType("text/html");
        out = response.getWriter();
        out.println("Welcome<br>");
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            System.out.println("in doGet in the if");
            out.println("<B>cookies opened</B>");
        } else {
            out.println("<B>please enable cookies</B>");
            System.out.println("in doGet in the else");
        }
    }
}
