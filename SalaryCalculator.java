import java.util.Scanner;


abstract class Employee {
    String name;
    int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();
}

class Manager extends Employee {
    double baseSalary;
    double bonus;

    public Manager(String name, int id, double baseSalary, double bonus) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return baseSalary + bonus;
    }
}

class Developer extends Employee {
    double baseSalary;
    double projectIncentive;

    public Developer(String name, int id, double baseSalary, double projectIncentive) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.projectIncentive = projectIncentive;
    }

    @Override
    double calculateSalary() {
        return baseSalary + projectIncentive;
    }
}

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Employee ID:");
        int id = scanner.nextInt();

        System.out.println("Select Employee Type: 1. Manager 2. Developer");
        int choice = scanner.nextInt();
        Employee emp;

        switch (choice) {
            case 1:
                System.out.println("Enter Base Salary:");
                double baseSalary = scanner.nextDouble();
                System.out.println("Enter Bonus:");
                double bonus = scanner.nextDouble();
                emp = new Manager(name, id, baseSalary, bonus);
                break;

            case 2:
                System.out.println("Enter Base Salary:");
                baseSalary = scanner.nextDouble();
                System.out.println("Enter Project Incentive:");
                double projectIncentive = scanner.nextDouble();
                emp = new Developer(name, id, baseSalary, projectIncentive);
                break;

            default:
                System.out.println("Invalid choice. Exiting...");
                scanner.close();
                return;
        }

        System.out.println("Employee Salary: " + emp.calculateSalary());
        scanner.close();
    }
}
