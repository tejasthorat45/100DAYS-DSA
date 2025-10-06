package LeetCode100Days;

public class DAY32_Q1423 {

    public static int findMAxSum(int nums[],int k){

        int n=nums.length;

        int leftsum=0; int maxsum=0;

        for (int i=0;i<k;i++) leftsum+=nums[i];

        int rigthsum =0, rightidx=n-1;

        for(int i=k-1;i>=0;i--){

            leftsum-=nums[i];
            rigthsum+=nums[rightidx];
            rightidx--;
            maxsum = Math.max(maxsum,leftsum+rigthsum);
        }

        return maxsum;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,1};
        int k=3;

        System.out.println(findMAxSum(nums,k));

    }
}
