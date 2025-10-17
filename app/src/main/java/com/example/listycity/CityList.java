package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist.
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * This function checks if the CityList contains the specific city
     * @param city The city to be checked in the list
     * @return a boolean that can be true or false, true means the list contains the city and false means that the city is not in the list.
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * This function removes a specific city from the list
     * @param city The city to be removed from the list
     * @throws IllegalArgumentException if the city is not in the list
     */

    public void delete(City city){
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("The city does not exist");
        }
    }

    /**
     * This function counts the number of cities in the cityList.
     * @return the number of cities in the cityList
     */
    public int countCities(){
        int count = 0;
        for (City city : cities) {
            count++;
        }
        return count;
    }
}
