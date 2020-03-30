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

public class Judge implements Comparable<Judge> {

    private int vote;

    public Judge() {
        this.vote = 0;
    }

    public int getVote() {
        return this.vote;
    }

    public void vote() {
        Random random = new Random();
        int min = 10;
        int max = 20;
        this.vote = random.nextInt((max - min) + 1) + min;
    }
    
    @Override
    public int compareTo(Judge judge){
        return this.vote - judge.getVote();
    }
    
    @Override
    public String toString(){
        return "" + this.vote;
    }

}
