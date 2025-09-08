package LeetCode100Days;
//day3

public class Trappedrainwater {

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


    }
}
