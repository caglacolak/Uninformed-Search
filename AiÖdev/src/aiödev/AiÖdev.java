/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aiödev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class AiÖdev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int index=0;
        float xCordinate,yCordinate;
        String line;
        String[] lineArray;
        File file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\djibouti.txt");

        Scanner input = new Scanner(System.in); 
        System.out.print("Lütfen seçmek istediğiniz ülkenin kodunu girin: 1-djibouti  2-qatar,  3-uruguay,   4-US-states   ,5-western sahara ");
        String mesaj = input.nextLine(); 
        if(mesaj.equals("1")){
            file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\djibouti.txt");
        }else if(mesaj.equals("2")){
            file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\qatar.txt");
        }else if(mesaj.contains("3")){
            file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\uruguay.txt");
        }else if(mesaj.equals("4")){
            file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\us-states.txt");
        }else if(mesaj.equals("5")){
            file=new File("C:\\Users\\ASUS\\Desktop\\tsp-data-20190402\\olcay-tsp\\western-sahara.txt");
        }else{
            System.out.print("Yanlış bir değer girdiniz!!! Lütfen seçmek istediğiniz ülkenin kodunu girin: 1-djibouti  2-qatar,  3-uruguay,   4-US-states   ,5-western sahara ");
            mesaj = input.nextLine(); 
        }
        
	try {
            Scanner sc=new Scanner(file);
			
            while(sc.hasNextLine()){
                line=sc.nextLine();
                                
                lineArray=line.split(" ");
		
                City city = new City( Integer.parseInt(lineArray[0]),Float.valueOf(lineArray[1]),Float.valueOf(lineArray[2]));
                DestinationManager.addCity(city);
            }
            sc.close();
            } catch (FileNotFoundException e) {
			
		e.printStackTrace();
            }
        
        

        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        //set population for 100 generations
        pop = GeneticA.evolvePopulation(pop);
        for (int i = 0; i < 100000; i++) {
            pop = GeneticA.evolvePopulation(pop);
        }

        
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
    
}
