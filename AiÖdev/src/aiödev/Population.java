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
public class Population {

    Destination[] destinations;

    public Population(int populationSize, boolean initialise) {
        destinations = new Destination[populationSize];
        if (initialise) {
            for (int i = 0; i < populationSize(); i++) {
                Destination newDestination = new Destination();
                newDestination.generateIndividual();
                saveDestination(i, newDestination);
            }
        }
    }
    
    public void saveDestination(int index, Destination destination) {
        destinations[index] = destination;
    }
    
    public Destination getDestination(int index) {
        return destinations[index];
    }

    public Destination getFittest() {
        Destination fittest = destinations[0];
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getDestination(i).getFitness()) {
                fittest = getDestination(i);
            }
        }
        return fittest;
    }

    public int populationSize() {
        return destinations.length;
    }
}
