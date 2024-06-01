import java.util.Scanner;

    public class java2 {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Input marks for each subject
            System.out.println("Enter the number of subjects: ");
            int numberOfSubjects = scanner.nextInt();
            int[] marks = new int[numberOfSubjects];
    
            for (int i = 0; i < numberOfSubjects; i++) {
                System.out.printf("Enter marks for subject %d (out of 100): ", i + 1);
                marks[i] = scanner.nextInt();
            }
    
            // Calculate total marks
            int totalMarks = 0;
            for (int mark : marks) {
                totalMarks += mark;
            }
    
            // Calculate average percentage
            double averagePercentage = (double) totalMarks / numberOfSubjects * 100;
    
            // Calculate grade
            String grade;
            if (averagePercentage >= 90) {
                grade = "A";
            } else if (averagePercentage >= 80) {
                grade = "B";
            } else if (averagePercentage >= 70) {
                grade = "C";
            } else if (averagePercentage >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
    
            // Display results
            System.out.println("\nResults:");
            System.out.println("Total Marks: " + totalMarks);
            System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
            System.out.println("Grade: " + grade);
    
            scanner.close();
        }
    }
    
    

