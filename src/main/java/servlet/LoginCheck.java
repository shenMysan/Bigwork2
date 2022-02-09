package servlet;
import Dao.LoginDAo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//控制层

@WebServlet("/LoginCheck")
    public class LoginCheck extends HttpServlet {

    String login_name;
        private static final long serialVersionUID = 1L;


        public LoginCheck() {
            super();
            // TODO Auto-generated constructor stub
        }


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            int type = Integer.parseInt(request.getParameter("type"));



                    if (id != null && password != null && new LoginDAo().isTure(id, password,type)) {
                        //将数据存储在request对象中，传递给下一个servlet使用
                       String  login_name[] = new String[]{  "Customer","Driver","Root" } ;
                        request.setAttribute("login_name",login_name[type-1]);
                        request.setAttribute("username", id);


                        //进行数据的转发
                        RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome");
                        dispatcher.forward(request, response);

                    } else {
                        response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "密码错误或账号不存在");
                    }







        }


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
        }








}
