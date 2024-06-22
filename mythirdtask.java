import java.util.InputMismatchException;
import java.util.Scanner;

public class mythirdtask {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numSubjects = getValidNumSubjects(scanner);

            String[] subjects = new String[numSubjects];
            int[] marks = new int[numSubjects];

            for (int i = 0; i < numSubjects; i++) {
                subjects[i] = getValidSubjectName(scanner, i + 1);
                marks[i] = getValidMarks(scanner, subjects[i]);
            }

            int totalMarks = calculateTotalMarks(marks);
            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

            System.out.println("Your Result is Here:");
            System.out.println("Your Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + averagePercentage + "%");

            String grade = calculateGrade(averagePercentage);
            System.out.println("Grade: " + grade);
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static int getValidNumSubjects(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Hey, Enter the Number of Subjects: ");
                int numSubjects = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (numSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                    continue;
                }
                return numSubjects;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static String getValidSubjectName(Scanner scanner, int subjectNumber) {
        while (true) {
            System.out.print("Enter name of Subject " + subjectNumber + ": ");
            String subjectName = scanner.nextLine();

            if (subjectName.trim().isEmpty()) {
                System.out.println("Subject name cannot be empty.");
                continue;
            }
            return subjectName;
        }
    }

    private static int getValidMarks(Scanner scanner, String subjectName) {
        while (true) {
            try {
                System.out.print("Enter marks obtained in " + subjectName + ": ");
                int marks = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }
                return marks;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        if (numSubjects == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return totalMarks / (double) numSubjects;
    }

    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
