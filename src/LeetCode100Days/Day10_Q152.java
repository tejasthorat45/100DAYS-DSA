package LeetCode100Days;

public class Day10_Q152 {

    public static int Optimal(int arr[]){

        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for(int i=1;i<arr.length;i++){

            //if we get -ve num then we have to swap maax and min prod

            if(arr[i]<0){
                int temp = maxProd;
                maxProd=minProd;
                minProd=temp;
            }

            maxProd = Math.max(arr[i],arr[i]*maxProd);
            minProd = Math.min(arr[i],arr[i]*minProd);
            result = Math.max(result,maxProd);


        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-2,3,-4};
        System.out.println(Optimal(arr));
    }
}
