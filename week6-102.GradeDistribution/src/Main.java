
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // implement your program here
        // do not put all to one method/class but rather design a proper structure to your program

        // Your program should use only one Scanner object, i.e., it is allowed to call 
        // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
        Grades grades = new Grades();

        while (true) {
            int score = Integer.parseInt(reader.nextLine());
            if (score == -1) {
                break;
            }
            grades.addScore(score);
        }

        System.out.println("Grade distribution:");
        grades.printGradesAsStars();
        System.out.println("Acceptance percentage: " +
                grades.acceptancePercentage());
    }
}
