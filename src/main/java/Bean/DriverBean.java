package Bean;

public class DriverBean {


    @Override
    public String toString() {
        return
                id +" "+
                 name  +" "+
                        pw  +" "+
                 oldTime +"\r\n";

    }

    public DriverBean(int id, String name, String oldTime,      String  pw ) {   //ID   名字，密码，注册日期
        this.id = id;
        this.name = name;
        this.oldTime = oldTime;
        this.pw=pw;
    }

    private int id ;
    private  String name;
    private   String  pw ;
    private   String  oldTime ;

    public String getPw() {
        return pw;
    }



    public void setPw(String pw) {
        this.pw = pw;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void setOldTime(String date) {
        oldTime = date.toString();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOldTime() {
        return oldTime;
    }

    public DriverBean(int id, String name,String  pw ) {
        this.id = id;
        this.name = name;
        this.pw=pw;

    }
public  DriverBean(){}







}


