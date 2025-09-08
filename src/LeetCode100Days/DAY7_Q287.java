package LeetCode100Days;
 // Duplicate Number in Array
public class DAY7_Q287 {

    //fast and slow Pointer Approach
    public static int isDuplicate(int arr[]){
        int n= arr.length;

        int slow =0;
        int fast =0;

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast); // if they meet send one pointer to stat of thier array

        slow = 0;

        while (slow!=fast){
            slow=arr[slow];
            fast = arr[fast];
        }

        return slow;


    }

    public static void main(String[] args) {

        int[] arr={1,2,3,2,4};

        System.out.println(isDuplicate(arr));



    }
}
