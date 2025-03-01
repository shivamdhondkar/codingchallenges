import java.util.Arrays;

public class LargestElement {
    public static int findKthLargest(int[] nums, int k) 
    {
        Arrays.sort(nums);
        System.out.println("Sorted array : "+Arrays.toString(nums));
        return nums[nums.length - k]; 
    }

    public static void main(String[] args) 
    {
        System.out.println("Finding the Kth largest elemrent in an array");
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 1;
        System.out.println("Kth Largest Element: " + findKthLargest(arr, k));
    }
}
