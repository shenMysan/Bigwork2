package Bean;



public class Order {

    private  int    orderid;
    private  String  Driverid;
    private  String Customerid;



    private  String distance;
    private  String price;

    public Order() {
    }

    public Order(int orderid, String driverid, String customerid, String price, String distance) {
        this.orderid = orderid;
        Driverid = driverid;
        Customerid = customerid;
        this.price = price;
        this.distance=distance;
    }


    public int getOrderid() {
        return orderid;
    }

    public String getDriverid() {
        return Driverid;
    }

    public String getCustomerid() {
        return Customerid;
    }

    public String getPrice() {
        return price;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public void setDriverid(String driverid) {
        Driverid = driverid;
    }

    public void setCustomerid(String customerid) {
        Customerid = customerid;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

public  String getorder(){
        return "司机"+Driverid+"已接单"+"距离你"+distance+"公里";
}


    @Override
    public String toString() {
        return orderid +" "  +Driverid + " " + Customerid + " " + distance + " "  + price + "\r\n";
    }
}
