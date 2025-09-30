package LeetCode100Days;

public class DAY27_q2221 {
    public static int solution(int nums[]){

        int n =nums.length;

        for(int size = n-1; size>=1;size--){

            for(int i=0;i<size ;i++){

                nums[i]= (nums[i]+nums[i+1])%10;

            }
        }

        return nums[0];

    }
    public static void main(String[] args) {
        int nums[] ={1,2,3,4,5};

        System.out.println(solution(nums));
    }
}
