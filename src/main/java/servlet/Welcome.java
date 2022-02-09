package servlet;


import java.io.IOException;
import java.sql.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String loginname1 = (String) request.getAttribute("login_name");
        //设置编码格式
        response.setContentType("text/html;charset=UTF-8");
        //返回html页面
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>登录信息</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body algin=center>");
        response.getWriter().println("欢迎【" + id+ "】用户登录成功！！！<br>");


        response.getWriter().println(" <a href='          /"+loginname1+"/"+loginname1+"Welcome.jsp?id="+id+"' target='_top'>");

        response.getWriter().println(     "点击跳转");
        response.getWriter().println(        " </a>");
        response.getWriter().println("</body>");

        response.getWriter().println("</html>");






    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
