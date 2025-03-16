

class Day2 {
    static int countFreq(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
          
            
            if (arr[i] == target)
                res++;
        }
      
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10,14,19,26,27,31,33,35,42,44};
        int target = 33;
        System.out.println(countFreq(arr, target));
    }
}
