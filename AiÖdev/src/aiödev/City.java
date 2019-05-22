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
public class City {
    float x;
    float y;
    private int index;
    
    // Constructs a randomly placed city
    public City(){
        this.index=(int)(Math.random()*200);
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(int index,float x, float y){
        this.index=index;
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public float getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public float getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        float xDistance = Math.abs(getX() - city.getX());
        float yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }
    @Override
    public String toString(){
        return getIndex()+", "+getX()+", "+getY();
    }

}