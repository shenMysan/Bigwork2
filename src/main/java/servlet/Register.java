package servlet;
import Dao.LoginDAo;
import Dao.RegisterDao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//控制层

@WebServlet("/Register")
public class Register extends HttpServlet {

    String login_name;
    private static final long serialVersionUID = 1L;


    public  Register() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));

        if (new RegisterDao().islive(id,type)) {
            //将数据存储在request对象中，传递给下一个servlet使用
            String time ="";
            if(type==2){

                Date date = new Date();
                SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
              time=   dateFormat.format(date);
            }
            String newUser ="\r\n"+id+" "+name+" "+password+" time";
            new RegisterDao().outdata(newUser,type);

            String  login_name[] = new String[]{  "Customer","Driver","Root" } ;
            request.setAttribute("login_name",login_name[type-1]);
            request.setAttribute("username", id);
            //进行数据的转发
            RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome");
            dispatcher.forward(request, response);

        } else {
            response.sendError(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "账号已存在");
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
