package LeetCode100Days;
//mAJORITY ELEMENT

import java.util.Arrays;

public class DAY5_Q169 {
    // brute fore
    public static int Approach1(int arr[]){
        int n = arr.length;

        int majorityelemnt = n/2;
        for(int i=0;i<n;i++){
            int cnt =0;
            for (int j=0;j<n;j++){
                if(arr[i]==arr[j]){
                    cnt++;

                }

            }

            if(cnt>majorityelemnt){
                return arr[i];
            }



        }
        return -1;


    }

    public static int Approches2(int nums[]){

        Arrays.sort(nums);

        int ans = nums.length/2;
        return nums[ans];
    }

    //a[pproch 3 boye morre voting technique
    public static int boyyeMore(int nums[]){



        int count =0;
        int candidate =0;

        for(int i=0;i< nums.length;i++){
            if(count==0){
                count++;
                candidate=nums[i];


            }else if (candidate==nums[i]){
                count++;
            }else{
                count--;
            }

        }

        return candidate;
    }

    public static void main(String[] args) {

        int nums[]={1,2,3,4,4,4,4,4};
        System.out.println(Approach1(nums));
        System.out.println(Approches2(nums));
        System.out.println(boyyeMore(nums));

    }
}
