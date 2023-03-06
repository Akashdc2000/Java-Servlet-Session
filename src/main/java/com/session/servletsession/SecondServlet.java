package com.session.servletsession;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "SecondServlet", value = "/SecondServlet")
public class SecondServlet extends HttpServlet {
    public String message="Hello";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        message="";
        Cookie cookies[]=request.getCookies();
        if(cookies==null)
            message="You Visit First Time";
        else{
            for(Cookie c:cookies){
                if(c.getName().equals("userName")){
                    message="Welcome back "+c.getValue();
                }
            }

        }
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("Second Servlet");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
