package module;

/**
 * Created by Sha0w on 2017/3/24.
 */
public class TestPoint {
    private double lat;
    private double lon;
    private String city;
    private String province;
    public TestPoint(double lat, double lon, String city, String province) {
        this.city = city;
        this.province = province;
        this.lat = lat;
        this.lon = lon;
    }
    public String toString(){
        return lat + "," + lon + "," + city + "," + province;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
