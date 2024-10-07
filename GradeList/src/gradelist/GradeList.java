package gradelist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class GradeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Enter 10 grades:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Grade " + (i + 1) + ": ");
            boolean validInput = false;
            while (!validInput) {
                try {
                    double grade = scanner.nextDouble();
                    grades.add(grade);
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner buffer
                }
            }
        }

        System.out.println("Grades entered: " + grades);
        
        double maxValue = grades.stream().max(Double::compare).orElse(Double.MIN_VALUE);
        System.out.println("Maximum grade: " + maxValue);
        
        double minValue = grades.stream().min(Double::compare).orElse(Double.MAX_VALUE);
        System.out.println("Minimum grade: " + minValue);
        
        double average = grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        System.out.println("Average grade: " + average);
    }
}
