package com.jakartaee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"es\">");
        out.println("    <head>");
        out.println("        <meta charset=\"UTF-8\">");
        out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.println("        <title>Hello</title>");
        out.println("        <style>");
        out.println("            body {");
        out.println("                max-width: max-content;");
        out.println("                margin: auto;");
        out.println("                text-align: center;");
        out.println("            }");
        out.println("        </style>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>Hello World - Jakarta EE</h1>");
        out.println("    </body>");
        out.println("</html>");

        out.close();

    }

}
