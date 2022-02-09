package Dao;

import Bean.Point;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FindCarDAO {
    public FindCarDAO() {

    }
    public String FindCar(String a, String b) throws InterruptedException, IOException, ParseException {

        int time =8;//30s； 30+60
        int i =1;


                       String mindistance =timer(a,b,i,time)  ;
        if (mindistance.equals("")){
            System.out.println("正在为你扩大范围");
            mindistance= timer(a,b,i*2,time*2);
            if (mindistance.equals("")){
                return  "暂无车辆,请重新打车";
            }
        }else {
            return  mindistance;
        }


        return  mindistance;
    }

     String [] search(String a,String b,int I) throws IOException {
              String  []correct =new String[10];  //最多只返回十个点
         int length =0;  //当前储存个数
       String path =this.getClass().getClassLoader().getResource("地址缓存.txt").getPath();  ;
         File file1 = new File(path );
         BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
         String DriverString;
         String []pointSplit=new String[3];
         String [] in_range =null;
         while ((DriverString = reader.readLine()) != null) {
           pointSplit= DriverString.split(" ");

               if (new Point().getDistance(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(pointSplit[0]),Double.parseDouble(pointSplit[1]) )<3*I  ){

                     correct[length]=DriverString +" "+new Point().getDistance(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(pointSplit[0]),Double.parseDouble(pointSplit[1]));

                     length++;

               }
         }
         if (length!=0){
          in_range =new String[length];
                            for (int j =0;j<length;j++){
                            in_range[j]=           correct[j];
                            }}

         return   in_range;
     }



     String  timer   (String a,String b,int I,int time) throws InterruptedException, IOException, ParseException {
         String Return[] = null;
         String minDistance="";

         for (int i=0;time>0;time--) {
             Return =  search(a,b,I);
             Thread.sleep(5000);
             System.out.println("剩余寻找车辆时间"+time);

         }
         if (Return!=null) {
             for (int i=0;i<Return.length;i++) {
             for(int j=0;j<Return.length-1-i;j++)
             {
                 double distance1= Double.parseDouble( Return[j].split(" ")[3]) ;
                 double distance2= Double.parseDouble( Return[j+1].split(" ")[3]) ;
                String Time =  new DriverDao().getTime( Return[j].split(" ")[2]);
                 String Time1 =  new DriverDao().getTime( Return[j+1].split(" ")[2]);

                 if(distance1>distance2)
                 {

                     String temp=Return[j];
                     Return[j]=Return[j+1];
                     Return[j+1]=temp;
                 }
                 if(distance1==distance2)
             {

                 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                 Date sd1=df.parse(Time);
                 Date sd2=df.parse(Time1);
               if (sd1.after(sd2)){
                   String temp=Return[j];
                   Return[j]=Return[j+1];
                   Return[j+1]=temp;
               }
             }
             }

         }
             minDistance=Return[0];
         }  //冒泡


       /*  if (minDistance.equals("")){

      *//*    minDistance= timer(a,b,I*2,time*2);   //递归*//*                     递归递个鬼，不能sleep加递归。主线程会直接结束!!!!!!!!!!!!!!!!!!!!!!!;   一下午的教训

         }else {
             return  minDistance;
         }*/
         System.out.println(minDistance);
      return minDistance;

     }








}
