package LeetCode100Days;
//findind max profuct of tu numi-1 * numj-1

public class DAY19_Q1464 {

    public static int bruteFore(int nums[]){

        int n= nums.length;

        int maxpro=0;
        //O(n2)tc sc =O(1)
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int currpro=0;
                currpro = (nums[i]-1)*(nums[j]-1);
                maxpro = Math.max(maxpro,currpro);



            }
        }
        return maxpro;
    }

    //using O(n) tc

    public static int Optimal(int nums[]){

        // find largest and second largest
        int largest =0;
        int secondLar =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>largest){
                secondLar=largest;
                largest=nums[i];
            }else if(nums[i]>secondLar){
                secondLar = nums[i];
            }

        }

        return (secondLar-1)*(largest-1);
    }

    public static void main(String[] args) {
        int arr[] ={2,3,1,4,5};
        System.out.println(bruteFore(arr));
        System.out.println(Optimal(arr));
    }
}
