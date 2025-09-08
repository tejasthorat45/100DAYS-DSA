package LeetCode100Days;
//product of array except itself

public class Day6_Q238 {
    public static int[] Appraoch1(int nums[]){
        int n = nums.length;

        //leftmultiplication

        int leftmul[] = new int[n];
        int rightmul[] = new int[n];
        leftmul[0]=1;


        for(int i=1;i<n;i++){
            leftmul[i]=leftmul[i-1]*nums[i-1];

        }

        //rightmultiplication
        rightmul[n-1]=1;
        for(int i = n-2;i>=0;i--){
            rightmul[i]=rightmul[i+1]*nums[i+1];

        }
        int ans[] = new int[n];

        for (int i=0;i<n;i++){

            ans[i] = leftmul[i]*rightmul[i];
        }
        return ans;
    }

    public static int[] Optimal(int arr[]){

        int n = arr.length;
        int ans[] = new int[n];

        //calculate the all leftmult
        ans[0]=arr[0];
        for(int i=1;i<n;i++){
            ans[i]=arr[i-1]*ans[i-1];
        }
        //suffix multiplicatio

        int suffix =1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*suffix;
            suffix = suffix*arr[i];

        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] ={1,2,3,4};

        int ans [] = Appraoch1(nums);
        for (int num :ans){
            System.out.print(num+" ");

        }
        System.out.println();

        int a[] = Optimal(nums);
        for (int num :a){
            System.out.print(num+" ");

        }
        System.out.println();




    }
}
