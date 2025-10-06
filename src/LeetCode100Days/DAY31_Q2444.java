package LeetCode100Days;
//leetcode hard  count the sub array with fixed bound
public class DAY31_Q2444 {

    public static int CountSubaaray(int nums[],int minK,int maxK) {


        int minkpostion = -1;
        int maxkpostion = -1;
        int ans = 0;
        int culpritidx = -1;

        for (int i = 0; i < nums.length; i++) {

            if(nums[i]<minK || nums[i]>maxK){
                culpritidx=i;


            }

            if(nums[i]==minK) minkpostion=i;
            if (nums[i]==maxK) maxkpostion=i;

            int slowest = Math.min(minkpostion,maxkpostion);
            int temp = slowest-culpritidx;
            ans+=(temp>0) ? temp : 0;



        }

        return ans;

    }

    public static void main(String[] args) {
        int nums[] ={1,3,5,2,7,5};
        System.out.println(CountSubaaray(nums,1,5));;

    }
}
