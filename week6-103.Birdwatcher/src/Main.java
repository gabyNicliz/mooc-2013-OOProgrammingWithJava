import java.util.Scanner;
import java.util.ArrayList;

public class Main {  

    public static void main(String[] args) {
    // implement your program here
    // do not put all to one method/class but rather design a proper structure to your program
        
    // Your program should use only one Scanner object, i.e., it is allowed to call 
    // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        Scanner reader = new Scanner(System.in);
        BirdwatcherDatabase birdDatabase = new BirdwatcherDatabase();
        String command;
        String birdName;
        String birdLatinName;
        
        while(true){
            System.out.print("? ");
            command = reader.nextLine();
            if(command.contains("Quit")){
                break;
            } else if(command.contains("Add")){
                System.out.print("Name: ");
                birdName = reader.nextLine();
                System.out.print("Latin Name: ");
                birdLatinName = reader.nextLine();
                Bird newBird = new Bird(birdName, birdLatinName);
                birdDatabase.add(newBird);
            } else if(command.contains("Observation")){
                System.out.print("What was observed:? ");
                birdName = reader.nextLine();
                birdDatabase.observed(birdName);
            } else if(command.contains("Statistics")){
                birdDatabase.printAllBirds();
            } else if(command.contains("Show")){
                System.out.print("What?");
                birdName = reader.nextLine();
                birdDatabase.printBird(birdName);
            } else {
                System.out.println("Wrong command! Type again.");
            }
        }
        
    }

}
