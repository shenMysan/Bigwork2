package Dao;

import Bean.Point;

import java.io.*;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Random;


public class PointDao {
    Sqlist<String>  poSqlist;
    public   String ReturnPoint( String ID) {
        poSqlist=  new Sqlist<String>();
        return insertSQlist(ID)  ;


}
public   PointDao( ) {


    }


 public  void  outdata (String string){

    try {
        String path=  this.getClass().getClassLoader().getResource("地址缓存.txt").getPath();
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
    void  indata (){
           poSqlist=  new Sqlist<String>();
        try {
            String path=  this.getClass().getClassLoader().getResource("地址缓存.txt").getPath();

            File file1 = new File(path );
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
            String DriverString;
            String []pointSplit=new String[3];
            String [] in_range =null;
            while ((DriverString = reader.readLine()) != null) {
                poSqlist.insert(DriverString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String insertSQlist(String ID) {
        indata();
        Point newpoint;
        double lng1 = 0;
        double lat1 = 0;
        Random randomLon = new Random();
        Random randomLat = new Random();
        double lon = ((double) (1132280 + randomLon.nextInt(2000))) / 10000;
        double lat = ((double) (232470 + randomLon.nextInt(1600))) / 10000;

        String str = "";
        String splitPoint[] = new String[2];

        boolean notlive = true;
        int i = 0;
        for (Object o : poSqlist) {
            splitPoint = o.toString().split(" ");
            if (splitPoint[2].equals(ID)) {
                lng1 = Double.parseDouble(splitPoint[0]);
                lat1 = Double.parseDouble(splitPoint[1]);
                if (lng1 > 113.128 && lng1 < 113.328) {
                    lng1 = lng1 + ((randomLon.nextDouble() * 2 - 1) * 0.000225);
                } else {
                    lng1 = 113.228;
                }
                if (lat1 > 23.327 && lat1 < 23.487) {
                    lat1 = lat1 + ((randomLat.nextDouble() * 2 - 1) * 0.00030);
                } else {
                    lat1 = 23.407;
                }
                newpoint = new Point(lng1, lat1, ID);

                poSqlist.unpdate(newpoint.toString(), i);
                notlive = false;
                break;
            }
            i++;
        }
        if (notlive) {
            lng1 = lon;
            lat1 = lat;
            newpoint = new Point(lng1, lat1, ID);

          poSqlist.   insert(newpoint.toString());  //初始化数据

        }
        for (Object o : poSqlist) {
            str += (String) o;
            str += "\r\n";

        }
                outdata(str);

        str = "";


        String data = lng1 + "," + lat1;

        return data;
    }

    public String updateSQlist(String str) {
        indata();
        String str1 = "";
        String splitPoint[] = new String[2];
        String  ID =str.split(" ")[2];
        for (Object o :poSqlist) {
        int  j =0;
            splitPoint = o.toString().split(" ");
            if (splitPoint[2].equals(ID)) {
                 poSqlist.unpdate(str,j);
            }

            j++;
        }
        for (Object o : poSqlist) {
            str1 += (String) o;
            str1 += "\r\n";

        }
        outdata(str1);

        str1 = "";

        return str1;
    }


}
