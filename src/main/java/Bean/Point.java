package Bean;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Point {

    double lng;
    double lat;
     String ID;
    public Point(double lng, double lat, String ID) {
        this.lng = lng;
        this.lat = lat;
        this.ID = ID;
    }

    public Point() {

    }


    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public double getLat() {
        return lat;
    }




    @Override
    public String toString() {
        return
                lng +" "+
                lat+" "+
                        ID
                ;
    }
    public   double getDistance(double lng_a, double lat_a, double lng_b, double lat_b){
        double pk = 180 / 3.14169;

        double a1 = lat_a / pk;

        double a2 = lng_a / pk;

        double b1 = lat_b / pk;

        double b2 = lng_b / pk;

        double t1 = Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2);

        double t2 = Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2);

        double t3 = Math.sin(a1) * Math.sin(b1);

        double tt = Math.acos(t1 + t2 + t3);
        double distance = (6371000 * tt/1000);
        BigDecimal b   =   new   BigDecimal(distance);


        DecimalFormat df = new DecimalFormat("#.00");

        return   Double.parseDouble( df.format(distance));

    }


}
