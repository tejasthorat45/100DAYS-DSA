package LeetCode100Days;

//day2

public class RemoveDuplicate {

    public static int RemoveDupli(int arr[]){
        int k =1;

        for(int i=1; i<arr.length;i++){

            if(arr[i] != arr[i-1]){
                arr[k] = arr[i];
                k++;

            }
        }
        return  k;
    }

    public static void main(String[] args) {

        int arr[] = { 1,1,2,3,4,4,5};
        int ans = RemoveDupli(arr);
        System.out.println(ans);

    }

}
