package com.Servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.FindFile.Search;

public class ReqAndResponse extends HttpServlet {

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
          response.setCharacterEncoding("UTF-8");
          String Gotdata = request.getParameter("userdata");
          List<Map<String, String>> info = Search.searchfile(Gotdata);
          request.setAttribute("result", info);
          request.setAttribute("name", Gotdata);
          RequestDispatcher jsp = request.getRequestDispatcher("success.jsp");
          jsp.forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

}
