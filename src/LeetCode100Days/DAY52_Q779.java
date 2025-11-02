package LeetCode100Days;

import javax.print.attribute.standard.Fidelity;

public class DAY52_Q779 {

    public static int findKthSymbol(int n , int k){

        //base case
        if(n==1&& k==1){
            return 0;
        }

        //find out len and mid
        int len = (int)Math.pow(2,n-1);

        int mid = len/2;

        if(k<=mid){
            return findKthSymbol(n-1,k);
        }else{
            return 1-findKthSymbol(n-1,k-mid);

        }



    }

    public static void main(String[] args) {

        System.out.println(findKthSymbol(3,3));
    }
}
