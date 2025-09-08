package LeetCode100Days;
//Day1 Q2

import java.util.Arrays;

public class TwoSum {

    public static int [] Approach1(int arr[],int tar){
        int res[] = new int[2];
        for(int i=0; i<arr.length;i++){

            for(int j =i+1;j< arr.length;j++){

                if(arr[i]+arr[j]==tar){
                    res[0] = i;
                    res[1]=j;
                }
            }
        }

        return res;
    }

    //appraoch 2 ; sort array

    public static int[] Approach2(int [] arr, int tar){

        Arrays.sort(arr);

        int left =0 , right = arr.length-1;

        while (left<right){
            if(arr[left]+arr[right]==tar){
                return new int[] {left,right};
            }

        }

        return arr;
    }



    public static void main(String[] args) {

        int arr[] = { 2,7,11,15};
        int k =9;
        int arr1[] = Approach1(arr,k);

        for (int i=0;i< arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();


    }

}
