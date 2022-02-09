package Dao;

import Bean.Order;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OrderDAO {
    Sqlist <String> Ordersqlist;
    public OrderDAO() {
        Sqlist <String> Ordersqlist ;
    }


    public  String teturnOrder(String type,String id) throws JSONException {
        indata();
        JSONObject object = new JSONObject();
        // 数组
        JSONArray jArray = new JSONArray();
        // 内层json
        JSONObject innerjObject = null;
        System.out.println(id);

        if (type.equals("Customer")) {

            for (Object o : Ordersqlist) {


                System.out.println(o);
                if (o.toString().split(" ")[2].equals(id)) {

                    innerjObject = new JSONObject();
                    innerjObject.put("orderid", o.toString().split(" ")[0]);
                    innerjObject.put("distance", o.toString().split(" ")[3]);
                    innerjObject.put("price", o.toString().split(" ")[4]);      //平台抽成
                    jArray.put(innerjObject);

                }



            }

        }
        if (type.equals("Driver")) {

            for (Object o2 : Ordersqlist) {
                if (o2.toString().split(" ")[1].equals(id)) {

                    innerjObject = new JSONObject();
                    innerjObject.put("orderid", o2.toString().split(" ")[0]);
                    innerjObject.put("distance", o2.toString().split(" ")[3]);

                    innerjObject.put("price", Double.parseDouble(  o2.toString().split(" ")[4] )*0.7);
                    jArray.put(innerjObject);

                }

            }

        }
        if (type.equals("Root")) {

            for (Object o1 : Ordersqlist) {


                    innerjObject = new JSONObject();

                    innerjObject.put("orderid", o1.toString().split(" ")[0]);
                innerjObject.put("Driverid", o1.toString().split(" ")[1]);
                innerjObject.put("Cusid", o1.toString().split(" ")[2]);
                    innerjObject.put("distance", o1.toString().split(" ")[3]);
                    innerjObject.put("price", o1.toString().split(" ")[4]);
                    jArray.put(innerjObject);

                }



        }


           object.put("info", jArray);

        System.out.println(  object.toString());
        return    object.toString();

    }
    void  indata (){
        Ordersqlist=  new Sqlist<String>();
        try {
            String path=  this.getClass().getClassLoader().getResource("订单").getPath();

            File file1 = new File(path );
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
            String DriverString;

            while ((DriverString = reader.readLine()) != null) {
              Ordersqlist.insert(DriverString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }              //把数据写入顺序表   ，方便遍历顺序表
    public  void  outdata (String string){

        try {
            String path=  this.getClass().getClassLoader().getResource("订单").getPath();
            File F1 = new File(path);
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(F1));
            bf.write(string.getBytes(StandardCharsets.UTF_8));
            bf.flush();
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
