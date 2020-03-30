/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private int points;
    private List<Integer> jumpPoints;

    public Jumper(String name) {
        this.jumpPoints = new ArrayList<Integer>();
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public void jump() {
        int low = 60;
        int high = 120;

        Random random = new Random();
        int jumpPoint = random.nextInt((high - low) + 1) + low;
        this.jumpPoints.add(jumpPoint);
        this.points += jumpPoint;
    }
    
    public void printJumpPoints(){
        for(int i = 1; i <= jumpPoints.size(); i++){
            System.out.print(jumpPoints.get(i-1) + " m");
            if(i < jumpPoints.size()){
                System.out.print(", ");
            } else {
                System.out.println("");
            }
        }
    }
    
    public List<Integer> getJumpPoints(){
        List<Integer> jumpPointsList = new ArrayList<Integer>();
        for(int jumpPoint : this.jumpPoints){
            jumpPointsList.add(jumpPoint);
        }
        return jumpPointsList;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper jumper) {
        return this.points - jumper.getPoints();
    }
}
