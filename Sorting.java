import java.util.Arrays;
import java.util.Collections;

public class Sorting {
    public static void main(String[] args) {
        Integer[] numbers = {7, 2, 9, 1,4,10,15,8,6,2 ,5};

        Arrays.sort(numbers);
        System.out.println("Ascending Order: " + Arrays.toString(numbers));

        Arrays.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending Order: " + Arrays.toString(numbers));
    }
}