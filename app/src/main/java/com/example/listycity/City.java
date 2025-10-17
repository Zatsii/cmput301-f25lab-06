package com.example.listycity;

/**
 * This is a class that defines a City
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    City(String city, String province) {
        this.city = city;
        this.province = province;
    }
    public String getCityName(){
        return this.city;
    }

    public String getProvinceName(){
        return this.province;
    }

    /**
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(City o) {
        City c = (City) o;
        return this.city.compareTo(c.getCityName());

    }
}
