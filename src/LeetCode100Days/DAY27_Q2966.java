package LeetCode100Days;

import java.util.Arrays;

public class DAY27_Q2966 {

    public static int[][] findDifference(int nums[], int k){
        int n= nums.length;

        // We have to sort the array

        Arrays.sort(nums);;


        // res 2d array
        int res [][] = new int[n/3][3];

        for(int i=0;i<n;i+=3){

            int a = nums[i],b = nums[i+1], c=nums[i+2];

            if(c-a>k){
                return new int[0][0];
            }

            res[i/3]= new int[]{a,b,c};




        }

        return res;
    }

    public static void main(String[] args) {

        int nums[] = {1,3,4,8,7,9,3,5,1};

        int arr [] [] = findDifference(nums,2);

        // Print 2D array
        for (int i = 0; i < arr.length; i++) {        // rows
            for (int j = 0; j < arr[i].length; j++) { // columns
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
