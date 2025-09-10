package LeetCode100Days;

import java.util.Stack;

public class Day9_Q901 {

    public static int[] spanproblem(int arr[],int span[]){

        Stack<Integer> st = new Stack<>();

        span[0] = 1;
        st.push(0);
        for(int i=1;i<arr.length;i++){
            int cuurentprice = arr[i];

            while(!st.isEmpty() && arr[st.peek()]<cuurentprice){
                st.pop();
            }
            if (st.isEmpty()){
                span[i]=i+1;
            }else{
                int privhigh = st.peek();
                span[i] = i-privhigh;
            }
            st.push(i);
        }
        return span;


    }

    public static void main(String[] args) {


        int[] arr ={100,80,60,70,60,75,85};
        int[] span = new int[arr.length];
        int [] ans = spanproblem(arr,span);

        for(int num : ans){
            System.out.print(num+" ");
        }


    }
}
