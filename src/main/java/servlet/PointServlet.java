package servlet;



import Dao.PointDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/returnPoint")
public class PointServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {


    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        String ID = request.getParameter("id");

String data =returndata(ID);
      PrintWriter out = response.getWriter();
      out.write(data);



    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



    String returndata(String ID) {


     String returndata = new PointDao().ReturnPoint(ID);


      return  returndata ;
    }

    @Override
    public void destroy() {
   new PointDao().outdata(" ");//清除点位
    }
}


