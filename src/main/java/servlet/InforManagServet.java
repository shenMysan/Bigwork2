package servlet;

import Dao.LoginDAo;
import Dao.OrderDAO;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/getInfor")
public class InforManagServet extends  HttpServlet {




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
             int type = Integer.parseInt(request.getParameter("usertype"));
            System.out.println(type);
            try {

                PrintWriter out = response.getWriter();
                out.write(   new LoginDAo().teturnInfor(type,id));
                out.close();

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }



}
