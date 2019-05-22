/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiödev;

/**
 *
 * @author ASUS
 */
import java.util.ArrayList;

public class DestinationManager {

    
    private static ArrayList destinationCities = new ArrayList<City>();

    
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    public static int numberOfCities(){
        return destinationCities.size();
    }
}