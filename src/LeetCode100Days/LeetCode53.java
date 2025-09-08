package LeetCode100Days;

//day4 : maxsubarray sum

public class LeetCode53 {

    // brute force

    public static int bruteForce(int arr[]){
        int n = arr.length;

        int maxsum=0;


        for (int i=0;i< arr.length;i++){
            int pairsum =arr[i];



            for (int j=i+1; j<n;j++){
                pairsum +=arr[j] ;

                maxsum = Math.max(pairsum,maxsum);


            }
        }

        return maxsum;
    }

    public static int maximumSubArray(int nums[]){

        int maxsum =nums[0];
        int cs =nums[0];

        for (int i=1;i<nums.length; i++){
             cs = Math.max(nums[i],nums[i]+cs );
             maxsum = Math.max(maxsum,cs);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int arr[]={-1,-2,3,4,5,-7,8};
        System.out.println(bruteForce(arr));
        System.out.println(maximumSubArray(arr));
    }
}
