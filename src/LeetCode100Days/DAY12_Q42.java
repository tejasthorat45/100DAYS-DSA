package LeetCode100Days;
//day3

public class DAY12_Q42 {

    public static int bruteForce(int arr[]){

        int n = arr.length;
        int leftmax[] = new int[n];
        leftmax[0]=arr[0];


        //cal left amx

        for(int i=1;i<n;i++){
           leftmax[i] = Math.max(leftmax[i-1],arr[i] );

        }
        //cal rigth max
        int rightmax[] = new int [n];
        rightmax[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            rightmax[i] = Math.max(arr[i],rightmax[i+1]);
        }
        //cal water level

       int trappedwater =0;
        for(int i=0;i<n;i++){
            int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trappedwater += waterlevel-arr[i];


        }
        return trappedwater;
    }

    public static int trapeedwater(int arr[]){
        int left =0; int right =arr.length-1;
        int leftmax=0;int rightmax =0;
        int wl=0;

        while(left<right){

            if(arr[left]<arr[right]){

                if(arr[left]>=leftmax){
                    leftmax=arr[left];
                } else {
                    wl += leftmax-arr[left];

                }
                left++;
            }else{
                if(arr[right]>=rightmax){
                    rightmax=arr[right];
                }else {
                    wl += rightmax-arr[right];
                }
                right--;
            }
        }
        return wl;
    }
    public static void main(String[] args) {

        int arr[]={4,2,0,5,3,2,4};
        System.out.println(trapeedwater(arr));
        System.out.println(bruteForce(arr));


    }
}
