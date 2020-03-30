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

public class Grades {

    private ArrayList<Integer> grades;
    private ArrayList<Integer> scores;
    private int accepted;

    public Grades() {
        this.grades = new ArrayList();
        this.scores = new ArrayList();
        this.accepted = 0;
    }

    public void addScore(int score) {
        if (score >= 0 && score <= 60) {
            this.scores.add(score);
            this.gradesDistribution(score);
            this.accepted(score);
        }
    }

    
    private void accepted(int score) {
        if (score > 29 && score <= 60) {
            this.accepted++;
        }
    }

    private void gradesDistribution(int score) {
        if (score <= 29) {
            this.grades.add(0);
        } else if (score > 29 && score <= 34) {
            this.grades.add(1);
        } else if (score > 34 && score <= 39) {
            this.grades.add(2);
        } else if (score > 39 && score <= 44) {
            this.grades.add(3);
        } else if (score > 44 && score <= 49) {
            this.grades.add(4);
        } else if (score > 49 && score <= 60) {
            this.grades.add(5);
        }
    }

    public void printGradesAsStars() {
        for (int i = 5; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int grade : this.grades) {
                if (grade == i) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public double acceptancePercentage() {
        int sumAllScores = 0;
        for (int score : this.scores) {
            sumAllScores++;
        }
        return (double) (100 * this.accepted) / sumAllScores;
    }
}
