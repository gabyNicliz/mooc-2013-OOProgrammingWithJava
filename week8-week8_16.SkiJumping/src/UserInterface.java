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
import java.util.Scanner;
import java.util.Collections;

public class UserInterface {

    private List<Jumper> jumpers;
    private Jury jury;
    private Scanner reader;

    public UserInterface() {
        this.jumpers = new ArrayList<Jumper>();
        this.jury = new Jury();
        this.reader = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n"
                + "\n"
                + "Write the names of the participants one at a time;"
                + " an empty string brings you to the jumping phase.");
        jury.addJudges(5);
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                System.out.println("\nThe tournament begins!\n");
                this.startTournament();
                break;
            }
            Jumper newJumper = new Jumper(name);
            this.jumpers.add(newJumper);
        }
    }

    private void startTournament() {
        int round = 0;
        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("\nThanks!\n");
                break;
            }
            round++;
            Collections.sort(jumpers);
            System.out.println("Round " + (round) + "\n\n"
                    + "Jumping order:");
            for (int i = 0; i < jumpers.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + jumpers.get(i));
                jumpers.get(i).jump();
            }
            System.out.println("Results of round " + (round));
            for (Jumper jumper : jumpers) {
                jury.juryVote();
                System.out.println("  " + jumper.getName()
                        + "\n    length: " + jumper.getJumpPoints().get(round-1));
                System.out.print("    judge votes: ");
                jury.printJury();
                jury.sortJudges();
                for (Judge judge : jury.getJudges()) {
                    int vote = judge.getVote();
                    jumper.addPoints(vote);
                };
            }
        }
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        System.out.println("Tournament results:\n"
                + "Position    Name");
        for (int i = 0; i < jumpers.size(); i++) {
            System.out.print((i + 1) + "           "
                    + jumpers.get(i) + "\n            jump lengths: ");
            jumpers.get(i).printJumpPoints();
        }
    }
}
