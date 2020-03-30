/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.ArrayList;

public class BirdwatcherDatabase {

    private ArrayList<Bird> birds;

    public BirdwatcherDatabase() {
        this.birds = new ArrayList();
    }

    public void add(Bird bird) {
        
        this.birds.add(bird);
    }

    public void observed(String name) {
        boolean isObserved = false;
        for (Bird bird : this.birds) {
            if (bird.getBirdName().contains(name)) {
                bird.increaseObserverd();
                isObserved = true;
            }
        }
        if(!isObserved){
            System.out.println("Is not a bird!");
        }
    }
    
    public void printBird(String birdName) {
        for (Bird bird : this.birds) {
            if (bird.getBirdName().contains(birdName)) {
                System.out.println(bird.toString());
            }
        }
    }

    public void printAllBirds() {
        for (Bird bird : this.birds) {
            System.out.println(bird.toString());
        }
    }
}
