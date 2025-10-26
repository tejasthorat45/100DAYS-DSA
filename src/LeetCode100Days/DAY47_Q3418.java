package LeetCode100Days;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DAY47_Q3418 {

    public static long[] findMaxSum(int nums1[],int nums2[],int k){
        //step1 :

        int n = nums1.length;
        int ans[][] = new int[n][3];


        for(int i=0;i<n;i++){
            ans[i][0]=nums1[i];
            ans[i][1]= i;
            ans[i][2]= nums2[i];
        }

        Arrays.sort(ans,(a,b)->Integer.compare(a[0],b[0]));  // soring )(logn)

        long res[] = new long[n];
        int sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();



        for(int i=0;i<n;i++){

            if(i>0 && ans[i-1][0]==ans[i][0]){

                long currans = res[ans[i-1][1]];

                res[ans[i][1]]=currans;

            }else{
                res[ans[i][1]]=sum;
            }
            pq.offer(ans[i][2]);
            sum+=ans[i][2];

            if(pq.size()>k){
                sum-=pq.poll();
            }
        }

        return res;




    }

    public static void main(String[] args) {
        DAY47_Q3418 obj = new DAY47_Q3418();

        int[] nums1 = {3, 1, 4, 2};
        int[] nums2 = {10, 20, 30, 40};
        int k = 2;

        long[] result = obj.findMaxSum(nums1, nums2, k);

        System.out.println("Result array:");
        System.out.println(Arrays.toString(result));
    }
}
