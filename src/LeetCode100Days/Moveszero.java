package LeetCode100Days;

public class Moveszero {
    public static void main(String[] args) {
        int nums[] = {1,2,0,4,5,0,7,0,9,8};
        moveZeros(nums);
        //priting the array
        for (int i=0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();

        //approach 2
        approach2(nums);
        //priting the array
        for (int i=0;i< nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();



    }
    // optimal
    private static int[] moveZeros(int[] nums) {

        int curr=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[curr]=nums[i];
                curr++;
            }
        }

        while(curr< nums.length){
            nums[curr]=0;
            curr++;
        }
        return nums;

    }

    //approach 2 not recomended

    public static int[] approach2(int nums[]){
        int n = nums.length;
        int write=0;

        for(int read=0;read<n;read++){
            if(nums[read]!=0){
                int temp = nums[write];
                nums[write] = nums[read];
                nums[read]=temp;
                write++;
            }
        }
        return nums;
    }
}
