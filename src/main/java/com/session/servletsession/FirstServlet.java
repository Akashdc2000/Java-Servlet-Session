package com.session.servletsession;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/first-servlet")
public class FirstServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Akash!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        message="Hello "+request.getParameter("email");

        if(request.getParameter("email")!=null)
        {
            Cookie c=new Cookie("userName",request.getParameter("email"));
            response.addCookie(c);
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<a href='second-servlet'>Second Servlet</a>");
        out.println("Click Here");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}