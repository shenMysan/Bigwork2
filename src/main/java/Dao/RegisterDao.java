package Dao;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RegisterDao {

    String path[]=new String[2];


    public RegisterDao() {
        path[1] =this.getClass().getClassLoader().getResource("司机.txt").getPath();
        path[0] =this.getClass().getClassLoader().getResource("顾客.txt").getPath();


    }








    public void  outdata(String string, int type){

        try {

            File F1 = new File(path[type-1]);
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(F1,true));
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



    public boolean islive(String id, int type) throws IOException {

            File file1 = new File(path[type-1]);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
            String DriverString;
            String []pointSplit=new String[3];
            String [] in_range =null;

            while ((DriverString = reader.readLine()) != null) {
                if( DriverString.split(" ")[0].equals(id))
                {
                    return  false;
                }


            }
         return  true;
    }



}
