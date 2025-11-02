package LeetCode100Days;
//CHECK ARRAY IS SORTED OR NOT

public class DAY55_qRECURSION {

    public static boolean isSorted(int arr[],int i){


        //base csse

        if(i== arr.length-1) return true;

        if(arr[i]>arr[i+1]) return false;

        return isSorted(arr,i+1);
    }

    public static void main(String[] args) {

        int arr[]={5,6,7,8};

        System.out.println(isSorted(arr,0));

    }
}
