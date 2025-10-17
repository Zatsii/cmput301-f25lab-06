package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CityListTest {
    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity(){
        return new City("Edmonton", "Alberta");
    }

    /**
     * Test on Add() method
     */
    @Test
    public void testAdd(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina","Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException(){
        CityList cityList = mockCityList();
        City city = new City("Yellowknife","Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Test on GetCities() method
     */
    @Test
    public void testGetCities(){
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city =  new City("Charolettetown","Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    /**
     * Test on hasCity() method
     */
    @Test
    public void testHasCity(){
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        cityList.delete(city);
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Test on delete() method
     */
    @Test
    public void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        cityList.delete(city);
        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Test on delete() method when there is an exception
     */
    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Toronto", "Ontario");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Test on countCities() method
     */
    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        assertEquals(1, cityList.getCities().size());
        City city = new City("Toronto", "Ontario");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        assertEquals(2, cityList.getCities().size());
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
        assertEquals(1, cityList.getCities().size());
    }

}
