import java.util.Scanner;

class Factorial
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number for factorial : ");
        int num = sc.nextInt();
        int fact = 1;

        while(num>=fact)
        {
            for(int i = 1; i<=num;i++)
            {
            fact = fact * i;
            
            }
        }
        System.out.println("Factorial = "+fact);

    }
}
