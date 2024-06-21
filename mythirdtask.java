import java.util.InputMismatchException;
import java.util.Scanner;

public class mythirdtask {
    public static void main(String[] args) {
        // Try-with-resources to ensure scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            int numSubjects = 0;

            // Loop to get the valid number of subjects
            while (true) {
                try {
                    System.out.print("Hey, Enter the Number of Subjects: ");
                    numSubjects = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // Check if number of subjects is greater than 0
                    if (numSubjects <= 0) {
                        System.out.println("Number of subjects must be greater than 0.");
                        continue; // Re-prompt the user
                    }
                    break; // Exit loop if valid input
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input
                }
            }

            // Arrays to store subject names and marks
            int[] marks = new int[numSubjects];
            String[] subjects = new String[numSubjects];

            // Loop to get subject names and corresponding marks
            for (int i = 0; i < numSubjects; i++) {
                // Prompt for subject name
                System.out.print("Enter name of Subject " + (i + 1) + ": ");
                subjects[i] = scanner.nextLine();

                // Loop to get valid marks for the subject
                while (true) {
                    try {
                        System.out.print("Enter marks obtained in " + subjects[i] + ": ");
                        marks[i] = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        // Check if marks are between 0 and 100
                        if (marks[i] < 0 || marks[i] > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            continue; // Re-prompt the user
                        }
                        break; // Exit loop if valid input
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number.");
                        scanner.nextLine(); // Clear the invalid input
                    }
                }
            }

            // Calculate total marks
            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }

            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numSubjects;
            System.out.println("Your Result is Here:");
            System.out.println("Your Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");

            // Calculate and print grade
            String grade = calculateGrade(averagePercentage);
            System.out.println("Grade: " + grade);
        } catch (Exception e) {
            // Catch any unexpected exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    // Method to calculate grade based on percentage
    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
