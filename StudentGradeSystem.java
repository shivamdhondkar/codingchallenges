import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }
}

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            Student student = new Student();

            System.out.print("Enter student name: ");
            student.setName(scanner.nextLine());

            System.out.print("Enter roll number: ");
            student.setRollNumber(scanner.nextInt());

            System.out.print("Enter grade (A, B, C, D, F): ");
            char grade = scanner.next().charAt(0);
            student.setGrade(grade);
            scanner.nextLine(); // Consume newline

            System.out.println("\nStudent Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());

            switch (Character.toUpperCase(grade)) {
                case 'A':
                    System.out.println("Excellent work!");
                    break;
                case 'B':
                    System.out.println("Good job!");
                    break;
                case 'C':
                    System.out.println("Fair effort, keep improving!");
                    break;
                case 'D':
                    System.out.println("Needs improvement, try harder!");
                    break;
                case 'F':
                    System.out.println("Failed, better luck next time!");
                    break;
                default:
                    System.out.println("Invalid grade entered.");
            }

            System.out.print("Do you want to enter details for another student? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            
            switch (choice) {
                case "yes":
                    continue;
                case "no":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Exiting the program.");
                    scanner.close();
                    return;
            }
        }
    }
}
