import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentPerformanceAnalyzer {

    static class Student {
        String name;
        Map<String, Double> grades;
        Map<String, Integer> attendance;
        Map<String, String> activities;

        public Student(String name) {
            this.name = name;
            this.grades = new HashMap<>();
            this.attendance = new HashMap<>();
            this.activities = new HashMap<>();
        }

        public void displayInfo() {
            System.out.println("\nStudent: " + name);
            System.out.println("Grades: " + grades);
            System.out.println("Attendance: " + attendance);
            System.out.println("Extracurricular Activities: " + activities);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Student> studentDatabase = new HashMap<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new student");
            System.out.println("2. Enter grades for a student");
            System.out.println("3. Enter attendance for a student");
            System.out.println("4. Enter extracurricular activities for a student");
            System.out.println("5. Display student information");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addNewStudent(scanner, studentDatabase);
                    break;
                case 2:
                    enterGrades(scanner, studentDatabase);
                    break;
                case 3:
                    enterAttendance(scanner, studentDatabase);
                    break;
                case 4:
                    enterActivities(scanner, studentDatabase);
                    break;
                case 5:
                    displayStudentInfo(scanner, studentDatabase);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addNewStudent(Scanner scanner, Map<String, Student> studentDatabase) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = new Student(name);
        studentDatabase.put(name, student);
        System.out.println("Student added successfully!");
    }

    private static void enterGrades(Scanner scanner, Map<String, Student> studentDatabase) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = studentDatabase.get(name);

        if (student != null) {
            System.out.print("Enter subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            student.grades.put(subject, grade);
            System.out.println("Grades entered successfully!");
        } else {
            System.out.println("Student not found. Please add the student first.");
        }
    }

    private static void enterAttendance(Scanner scanner, Map<String, Student> studentDatabase) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = studentDatabase.get(name);
if (student != null) {
            System.out.print("Enter date: ");
            String date = scanner.nextLine();
            System.out.print("Enter attendance (1 for present, 0 for absent): ");
            int attendance = scanner.nextInt();
            student.attendance.put(date, attendance);
            System.out.println("Attendance entered successfully!");
        } else {
            System.out.println("Student not found. Please add the student first.");
        }
    }

    private static void enterActivities(Scanner scanner, Map<String, Student> studentDatabase) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = studentDatabase.get(name);

        if (student != null) {
            System.out.print("Enter activity name: ");
            String activityName = scanner.nextLine();
            System.out.print("Enter description: ");
            String description = scanner.nextLine();
            student.activities.put(activityName, description);
            System.out.println("Extracurricular activities entered successfully!");
        } else {
            System.out.println("Student not found. Please add the student first.");
        }
    }

    private static void displayStudentInfo(Scanner scanner, Map<String, Student> studentDatabase) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = studentDatabase.get(name);

        if (student != null) {
            student.displayInfo();
        } else {
            System.out.println("Student not found.");
        }
    }
}
