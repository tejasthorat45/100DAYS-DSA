package LeetCode100Days;

public class DAY56_FirstOcuurance {

    public static int FirstOcuur(int arr[],int key,int i){

        //base case
        if(i== arr.length-1) return -1;

        if(arr[i]==key) return i;

        return FirstOcuur(arr,key,i+1);
    }

    public static void main(String[] args) {

        int arr[] ={1,2,3,4,5,67,8};
        System.out.println(FirstOcuur(arr,4,0));

    }
}
