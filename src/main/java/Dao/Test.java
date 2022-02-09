package Dao;

import Bean.Point;

import java.io.*;
import java.nio.charset.StandardCharsets;




public class Test {

static String  a = String.valueOf(113.24);
static String  b = String.valueOf(23.408);
    public static void main(String[] args) throws InterruptedException, IOException {
        int time = 30;
        for (int i=0;time>0;time--) {

            timer(a,b,1,10);
            Thread.sleep(1000);

        }

}




    static String [] search(String a, String b, int I) throws IOException {
        String  []correct =new String[10];  //最多只返回十个点
        int length =0;  //当前储存个数

        File file1 = new File("M:/test/src/main/java/Dao/地址缓存.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
        String DriverString;
        String []pointSplit=new String[3];
        String [] in_range =null;
        System.out.println(I);
        while ((DriverString = reader.readLine()) != null) {
            pointSplit= DriverString.split(" ");


            if (new Point().getDistance(Double.parseDouble(a),Double.parseDouble(b),Double.parseDouble(pointSplit[0]),Double.parseDouble(pointSplit[1]) )<3*I  ){
                if (I>3){
                    break;
                }
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



    static String  timer(String a, String b, int I, int time) throws InterruptedException, IOException {
        String Return[] = null;
        String minDistance="";

        for (int i=0;time>0;time--) {
            Return =  search(a,b,I);
            Thread.sleep(1000);

        }
        if (Return!=null) {
            for (int i=0;i<Return.length;i++) {
                for(int j=0;j<Return.length-1-i;j++)
                {
                    double distance1= Double.parseDouble( Return[j].split(" ")[2]) ;
                    double distance2= Double.parseDouble( Return[j+1].split(" ")[2]) ;
                    if(distance1>distance2)
                    {

                        String temp=Return[j];
                        Return[j]=Return[j+1];
                        Return[j+1]=temp;
                    }
                }

            }
            minDistance=Return[0];
        }  //冒泡


        if (minDistance.equals("")){

              minDistance= timer(a,b,I*2,time*2);

        }else {
            return  minDistance;
        }
        return minDistance;

    }



 }