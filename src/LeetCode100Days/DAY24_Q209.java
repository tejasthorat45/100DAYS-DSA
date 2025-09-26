package LeetCode100Days;

public class DAY24_Q209 {

    public static int bruteForce(int nums[],int tar){

        int n = nums.length;
        int minlen = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int sum =0;

            for(int j=i;j<n;j++){
                sum+= nums[j];
                if(sum>=tar){
                    minlen = Math.min(minlen,j-i+1);
                    break;
                }

            }
        }
        return minlen == Integer.MAX_VALUE ? 0:minlen;

    }

    public static int Slinding(int nums[],int tar){

        int i=0;int j=0;
        int minlen = Integer.MAX_VALUE;

        int sum =0;

        while(j<nums.length){

            sum+=nums[j];

            while(sum>=tar){
                minlen = Math.min(minlen,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }

    public static void main(String[] args) {
        int nums[] ={2,3,1,2,4,3};
        int tsrget = 7;
        System.out.println(bruteForce(nums,tsrget));
        System.out.println(Slinding(nums,tsrget));


    }
}
