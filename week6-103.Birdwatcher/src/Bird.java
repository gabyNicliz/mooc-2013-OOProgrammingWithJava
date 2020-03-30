/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
public class Bird {

    private String birdName;
    private String birdLatinName;
    private int timesObserved;
    
    public Bird(){
        this("", "");
    }
    
    public Bird(String birdName, String birdLatinName) {
        this.birdName = birdName;
        this.birdLatinName = birdLatinName;
        this.timesObserved = 0;
    }

    public void setBirdLatinName(String birdLatinName) {
        this.birdLatinName = birdLatinName;
    }
    
    public void setBirdName(String birdName){
        this.birdName = birdName;
    }
    
    public String getBirdName(){
        return this.birdName;
    }
    
    public String getBirdLatinName(){
        return this.birdLatinName;
    }
    
    public void increaseObserverd(){
        this.timesObserved++;
    }
    
    public int getObservedTimes(){
        return this.timesObserved;
    }
    
    public String toString(){
        return this.birdName + " (" + this.birdLatinName + "): "
                + this.getObservedTimes();
    }
}
