import java.util.ArrayList;
import java.util.Scanner;

public class GradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter grade for " + name + ": ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            students.add(new Student(name, grade));
        }

        // Process data
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            double g = s.getGrade();
            total += g;

            if (g > highest) {
                highest = g;
                topStudent = s.getName();
            }

            if (g < lowest) {
                lowest = g;
                lowStudent = s.getName();
            }
        }

        double average = total / n;

        // Display report
        System.out.println("\n===== Summary Report =====");
        for (Student s : students) {
            System.out.println("Student: " + s.getName() + ", Grade: " + s.getGrade());
        }
        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Grade: " + lowest + " (by " + lowStudent + ")");
    }
}
