import java.util.*;


class University {
    static String universityName = "XYZ University";

    public static void changeUniversityName(String name) {
        universityName = name;
    }

    public final void getUniversityDetails() {
        System.out.println("University Name: " + universityName);
    }
}

class Student {
    int studentID;
    String studentName;
    String course;
    final int admissionYear; 
    static int totalStudents = 0;

    public Student(int studentID, String studentName, String course, int admissionYear) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.course = course;
        this.admissionYear = admissionYear;
        totalStudents++;
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + studentName);
        System.out.println("Course: " + course);
        System.out.println("Admission Year: " + admissionYear);
    }
}

public class UniversityInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University();

        university.getUniversityDetails();

        System.out.print("Do you want to change the university name? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new university name: ");
            String newName = scanner.nextLine();
            University.changeUniversityName(newName);
        }

        university.getUniversityDetails();

        System.out.print("Enter number of students to register: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student #" + (i + 1));

            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Course: ");
            String course = scanner.nextLine();

            System.out.print("Enter Admission Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            students[i] = new Student(id, name, course, year);
        }

        System.out.println("\n--- Registered Students ---");
        for (Student s : students) {
            s.displayStudentDetails();
            System.out.println();
        }

        System.out.println("Total Enrolled Students: " + Student.totalStudents);

        scanner.close();
    }
}
