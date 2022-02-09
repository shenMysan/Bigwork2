package servlet;

import Bean.Order;
import Bean.Point;
import Dao.*;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;


@WebServlet("/FindCar")

public class FindCarservlet   extends HttpServlet {
    LinkQueue<String> Car;            //队列进行等待
    Sqlist<String> pointSQList;
    int orderid;
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        response.setContentType("application/json;charset=utf-8");
	response.setCharacterEncoding("UTF-8");
   //     response.setCharacterEncoding("GBK");

        System.out.println("已经连接服务器");
        String distance = request.getParameter(" distance");
        String price = request.getParameter("price");
        String id = request.getParameter("id");
        String lng_a = request.getParameter("lng_a");
        String lat_a = request.getParameter("lat_a");
        String lng_b = request.getParameter("lng_b");
        String lat_b = request.getParameter("lat_b");
        String theid=null;


        System.out.println("lng_a坐标为"+lng_a+"lat_a坐标为"+lat_a);
        System.out.println("lng_b坐标为"+lng_b+"lat_a坐标为"+lat_b);
        String  startpoint[]=new String[3];
        JSONObject  jsonObject=new JSONObject();
        PrintWriter out = response.getWriter();


        try {

            String  newPOint =          mathCAR(lng_a, lat_a);
            if ( newPOint.equals("暂无车辆,请重新打车")) {

                jsonObject.put("infor","暂无车辆,请重新打车");

                System.out.println("暂无车辆,请重新打车");
            } else {
                         startpoint= newPOint.split(" ");
                       theid =startpoint[2];
                         String thedistance =startpoint[2];

                System.out.println("司机"+theid+"已接单"+"距离你"+thedistance+"公里");
                Order order =new Order(orderid,theid,id,price,thedistance);
                new OrderDAO().outdata(order.toString());
                jsonObject.put("infor",order.getorder());
                jsonObject.put("ok",true);
                jsonObject.put("url","/Driver/1.html?id="+theid);
                out.write(jsonObject.toString());
                out.close();
                System.out.println(jsonObject.toString());
                inCAR(theid,  lng_a ,lat_a,lng_b, lat_b);

                orderid++;
            }   // lng lat id  distance

            out.write(jsonObject.toString());
            out.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }





    @Override
    public void init() throws ServletException {
orderid=1;

    }

    String mathCAR(String lng_a, String lat_a) throws IOException, InterruptedException, ParseException {


        String mindistance = new FindCarDAO().FindCar(lng_a, lat_a);


        return mindistance;
    }
    void inCAR( String id, String lng_a,String lat_a,String finalylng_b,String finalylat_b) throws InterruptedException {

        PointDao pointDao =new PointDao();

            Thread.sleep(2000);
        double  lngspeed =(Double.parseDouble(finalylng_b)-Double.parseDouble( lng_a))/20;   //20s 到达目的地
        double  latspeed  =(Double.parseDouble(finalylat_b)-Double.parseDouble( lat_a))/20;
        System.out.println("你已经上车");
           for (int i=0;i<20;i++){
               System.out.println(i);
              String dangqianlng = String.valueOf(Double.parseDouble( lng_a)+lngspeed*i);
               String  danqianlat= String.valueOf(Double.parseDouble( lat_a)+latspeed*i);

               Thread.sleep(6000);
               pointDao.updateSQlist(dangqianlng+" " +danqianlat+" "+id);
               pointDao.updateSQlist(dangqianlng+" " +danqianlat+" "+id);
               if(i==19){
                   System.out.println("已经到达终点");
               }
}



    }





}