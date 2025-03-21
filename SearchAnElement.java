
import java.util.Scanner;

public class SearchAnElement {
    public static void main(String args[]){
        int[] Arr ={3, 8, 1, 7, 5, 9,10,14,17,77,54,4};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to check:");
        int num = sc.nextInt();
        int len = Arr.length;
        for (int i =0; i <len;i++)
        {
            if(Arr[i] == num){
                if(true){
                    System.out.println("Element found");
                }

                else if (false){
                    System.out.println("Element not found");
                }
              
            }
           
            

        }
        
    }
}
