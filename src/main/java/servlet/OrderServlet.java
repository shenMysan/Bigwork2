package servlet;

import Dao.OrderDAO;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.applet.Applet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getOrder")
public class OrderServlet extends  HttpServlet  {


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String id = request.getParameter("id");
        String type = request.getParameter("usertype");
        System.out.println(type);
        try {

            PrintWriter out = response.getWriter();
            out.write(   new OrderDAO().teturnOrder(type,id));


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
