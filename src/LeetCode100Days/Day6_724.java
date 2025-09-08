package LeetCode100Days;
//day6 Pivot index 724


public class Day6_724 {

    public static int Approch1(int nums[]){
        int n = nums.length;;
        //leftsum array
        int leftsum[]=new int[n];
        leftsum[0]=0;

        for(int i=1;i<n;i++){
            leftsum[i]= leftsum[i-1]+nums[i-1];

        }
        //rightsum

        int rightsum[]=new int[n];
        rightsum[n-1]=0;
        for(int j=n-2;j>=0;j--){
            rightsum[j] = rightsum[j+1]+nums[j+1];

        }
        //third loop for leftsumm==rightsum return nums[i]

        for (int k =0;k<n;k++){
            if(leftsum[k]==rightsum[k]){
                return nums[k];
            }

        }
        return -1;




    }

    public static int optimal(int nums[]){


        int totalsum = 0;
        for (int val : nums){
            totalsum+=val;
        }

        int leftsum =0;
        for(int i=0;i<nums.length;i++){

            if (leftsum==totalsum-nums[i]-leftsum){
                return nums[i];
            }
            leftsum+=nums[i];
        }

        return -1;
    }



    public static void main(String[] args) {

        int nums[] ={1,2,3,6,6};
        System.out.println(Approch1(nums));

        System.out.println(optimal(nums));



    }
}
