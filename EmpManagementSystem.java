import java.util.Scanner;

class Employee {
    int id;
    String name;
    String designation;
    double salary;

    public Employee() {
        this(0, "Unknown", "Intern", 0.0);
    }

    public Employee(int id, String name) {
        this(id, name, "Intern", 0.0);
    }

    public Employee(int id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Salary: " + salary);
        System.out.println("------------------------");
    }
}

public class EmpManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee emp1 = new Employee();

        System.out.print("Enter ID for Employee 2: ");
        int id2 = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name for Employee 2: ");
        String name2 = scanner.nextLine();

        Employee emp2 = new Employee(id2, name2);

        System.out.print("Enter ID for Employee 3: ");
        int id3 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name for Employee 3: ");
        String name3 = scanner.nextLine();

        System.out.print("Enter Designation for Employee 3: ");
        String designation3 = scanner.nextLine();

        System.out.print("Enter Salary for Employee 3: ");
        double salary3 = scanner.nextDouble();

        Employee emp3 = new Employee(id3, name3, designation3, salary3);

        System.out.println("\n--- Employee Details ---");
        emp1.display();
        emp2.display();
        emp3.display();

        scanner.close();
    }
}
