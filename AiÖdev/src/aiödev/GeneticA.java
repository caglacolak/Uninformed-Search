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
public class GeneticA {

    /* GeneticA parameters */
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.populationSize(), false);

        int elitismOffset = 0;
        if (elitism) {
            newPopulation.saveDestination(0, pop.getFittest());
            elitismOffset = 1;
        }

        
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Select parents
            Destination parent1 = tournamentSelection(pop);
            Destination parent2 = tournamentSelection(pop);
            // Crossover parents
            Destination child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveDestination(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getDestination(i));
        }

        return newPopulation;
    }

   
    public static Destination crossover(Destination parent1, Destination parent2) {
        Destination child = new Destination();

        int startPos = (int) (Math.random() * parent1.tourSize());
        int endPos = (int) (Math.random() * parent1.tourSize());

        for (int i = 0; i < child.tourSize(); i++) {
            if (startPos < endPos && i > startPos && i < endPos) {
                child.setCity(i, parent1.getCity(i));
            } 
            else if (startPos > endPos) {
                if (!(i < startPos && i > endPos)) {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        for (int i = 0; i < parent2.tourSize(); i++) {
            if (!child.containsCity(parent2.getCity(i))) {
                for (int ii = 0; ii < child.tourSize(); ii++) {
                    if (child.getCity(ii) == null) {
                        child.setCity(ii, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    private static void mutate(Destination dest) {
        for(int destPos1=0; destPos1 < dest.tourSize(); destPos1++){
            if(Math.random() < mutationRate){
                int destPos2 = (int) (dest.tourSize() * Math.random());

                City city1 = dest.getCity(destPos1);
                City city2 = dest.getCity(destPos2);

                dest.setCity(destPos2, city1);
                dest.setCity(destPos1, city2);
            }
        }
    }

    private static Destination tournamentSelection(Population pop) {
        Population tournament = new Population(tournamentSize, false);
       
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.populationSize());
            tournament.saveDestination(i, pop.getDestination(randomId));
        }
        Destination fittest = tournament.getFittest();
        return fittest;
    }
}