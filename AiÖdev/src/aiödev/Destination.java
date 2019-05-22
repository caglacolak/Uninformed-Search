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
import java.util.Collections;

public class Destination{

    
    private ArrayList tour = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    
    public Destination(){
        for (int i = 0; i < DestinationManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    public Destination(ArrayList tour){
        this.tour = tour;
    }

    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < DestinationManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, DestinationManager.getCity(cityIndex));
        }
        Collections.shuffle(tour);
    }

    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        fitness = 0;
        distance = 0;
    }
    
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }
    
    public int getDistance(){
        if (distance == 0) {
            int destinationDistance = 0;
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
 
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                destinationDistance += fromCity.distanceTo(destinationCity);
            }
            distance = destinationDistance;
        }
        return distance;
    }

    public int tourSize() {
        return tour.size();
    }
    
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}