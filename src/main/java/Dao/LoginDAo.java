package Dao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.text.BreakIterator;
import java.util.Arrays;


public class LoginDAo {
     String[] splitDriver=new String[4];
     Sqlist <String>sqlist ;
    String []s =new String[3];
    public LoginDAo() {


    }


    void readData(int type) throws FileNotFoundException {
        sqlist = new Sqlist<String>();
        try {

            s[1] =this.getClass().getClassLoader().getResource("司机.txt").getPath();  //获取路径

            s[2] =this.getClass().getClassLoader().getResource("管理员.txt").getPath();  ;
            s[0] =this.getClass().getClassLoader().getResource("顾客.txt").getPath();  ;
            File file1 = new File( s[type-1]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
            String DriverString;
            while ((DriverString = reader.readLine()) != null) {


                sqlist.insert(DriverString);
                //ID   名字，密码，注册日期


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public   Boolean isTure(String  id, String password,int type) throws FileNotFoundException {
        Boolean   istr =false;                          //ID   名字，密码，注册日期
           readData(type);


        for(Object o:sqlist){                              //遍历顺序表 获取   账号

            splitDriver =((String)o).split(" ");

         if (splitDriver[0].equals(id)&&splitDriver[2].equals(password)){

             istr=true;

             break;
         }

        }


        return  istr;
    }
    public  String teturnInfor(int type,String id) throws JSONException, FileNotFoundException {
        readData(type);
        JSONObject object = new JSONObject();
        // 数组
        JSONArray jArray = new JSONArray();
        // 内层json
        JSONObject innerjObject = null;
        System.out.println(id);
            for (Object o1:  sqlist) {
                System.out.println(o1);
                if (o1.toString().split(" ")[0].equals(id)) {

                    innerjObject = new JSONObject();
                    innerjObject.put("id", o1.toString().split(" ")[0]);
                    innerjObject.put("name", o1.toString().split(" ")[1]);
                    innerjObject.put("pw", o1.toString().split(" ")[2]);      //平台抽成
                    jArray.put(innerjObject);

                }else  if (id.equals("root")){
                    innerjObject = new JSONObject();
                    innerjObject.put("id", o1.toString().split(" ")[0]);
                    innerjObject.put("name", o1.toString().split(" ")[1]);
                    innerjObject.put("pw", o1.toString().split(" ")[2]);      //平台抽成
                    jArray.put(innerjObject);



                }

        }


        object.put("info", jArray);

        System.out.println(  object.toString());
        return    object.toString();

    }


}