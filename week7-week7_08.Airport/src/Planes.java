/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.HashMap;
public class Planes {
    private HashMap<String, Integer> planes;
    
    public Planes(){
        this.planes = new HashMap<String, Integer>();
    }
    
    public void addPlane(String planeID, int planeCapacity){
        if(this.planes.get(planeID) == null){
            this.planes.put(planeID, planeCapacity);
        }
    }
    
    public String printPlane(String id){
        if(this.planes.get(id) != null){
            String plane = id + " (" + this.planes.get(id) + " ppl)";
            return plane;
        }
        return "There's no plane with that ID";
    }
    
    public void printPlanes(){
        for(String key : this.planes.keySet()){
            System.out.println(key + " (" + this.planes.get(key) + " ppl)");
        }
    }
}
