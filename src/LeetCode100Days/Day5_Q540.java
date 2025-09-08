package LeetCode100Days;


//SINGLE ELEMENT IN SORTED ARRAY

public class Day5_Q540 {

    public static int approach1(int nums[]){

        for(int i =0;i< nums.length-1;i+=2){

            if(nums[i]!=nums[i+1]){
                return nums[i];
            }

        }
        return -1;
    }

    // optimAL using binarry seacrh
    public static int OptimalApproach(int nums[]){

        int left =0,right= nums.length;

        while(left<right){

            int mid = left+(right-left)/2;

            if(mid%2==1){
                mid--; //make the mid odd bea

            } else if (nums[mid]==nums[mid+1]) {
                left = mid+2;

            }else{
                right=mid;
            }


        }
        return nums[left];

    }

    public static void main(String[] args) {

        int nums[] ={1,1,2,2,3,4,4,5,5};
        System.out.println(approach1(nums));
        System.out.println(OptimalApproach(nums));



    }


}
