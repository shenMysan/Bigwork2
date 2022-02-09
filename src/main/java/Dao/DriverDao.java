package Dao;

import Bean.DriverBean;

import java.io.*;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverDao {
            Sqlist <String> data =new Sqlist<String>();
    public void indata() throws IOException {
        String path =this.getClass().getClassLoader().getResource("司机.txt").getPath();  ;
        File file1 = new File(path );
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1), StandardCharsets.UTF_8));
        String DriverString;
        String []pointSplit=new String[3];
        String [] in_range =null;
        while ((DriverString = reader.readLine()) != null) {
            data.insert(DriverString);

        }

    }
    public String getTime(String s) {
        String time="";
for (Object o:data){
    if (o.toString().split("")[0].equals(s)){
        time =o.toString().split("")[3];
    }
}
        return time;
    }


}
