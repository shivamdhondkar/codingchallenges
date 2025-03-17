import java.util.Scanner;

class Day3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check : ");
        int n = sc.nextInt();

        if (n<=1)
        {
            System.out.println("Enter a valid number");
        }

        for (int i = 2; i<n ;i++)
        {
            if (n % i == 0){
                System.out.println("Not Prime");
               
            }
            else
            {
                System.out.println("Prime");
                
            }
            break;
        }
    }
}
