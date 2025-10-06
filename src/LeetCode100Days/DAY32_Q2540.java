package LeetCode100Days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//min element in both sorted array
public class DAY32_Q2540 {

    public static int Solution(int  nums1[],int nums2[]){

        int i=0;int j=0;

        while(i<nums1.length && j<nums2.length){

            if(nums1[i]==nums2[j]){
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            }else{
                j++;
            }


        }

        return 0;
    }

    public static int[] Approach2(int nums1[],int nums2[]){
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i =0;
        int j=0;
        int m  =nums1.length;
        int n = nums2.length;

        while(i<m && j<n){

            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);

                while(i<m-1 && nums1[i]==nums1[i+1]){
                    i++;
                }

                while(j<n-1 && nums2[j]==nums2[j+1]){
                    j++;
                }
                i++;
                j++;


            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
        }

        int res[] = list.stream().mapToInt(Integer::intValue).toArray();

        return res;

    }

    public static void main(String[] args) {
        int nums1[]={2,3,4};
        int nums2[]={3,5,7,};
        System.out.println(Solution(nums1,nums2));
    }
}
