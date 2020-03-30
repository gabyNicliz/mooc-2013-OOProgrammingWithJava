/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryzen
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Jury {

    private List<Judge> judges;

    public Jury() {
        this.judges = new ArrayList<Judge>();
    }

    public void addJudge(Judge judge) {
        this.judges.add(judge);
    }
    
    public void addJudges(int amount){
        for(int i = 0; i < amount; i++){
            Judge judge = new Judge();
            this.addJudge(judge);
        }
    }

    public void juryVote() {
        for (Judge judge : this.judges) {
            judge.vote();
        }
    }

    public List<Judge> getJudges() {
        List<Judge> judgesList = new ArrayList<Judge>();
        for(int i = 1; i < judges.size()-1;i++){
            judgesList.add(judges.get(i));
        }

        return judgesList;
    }
    
    public void printJury(){
        System.out.print("[");
        for(int i = 1; i <= judges.size(); i++){
            System.out.print(judges.get(i-1));
            if(i < judges.size()){
                System.out.print(", ");
            } else if(i == judges.size()){
                System.out.println("]");
            }
        }
    }
    
    public void sortJudges(){
        Collections.sort(judges);
    }
}
