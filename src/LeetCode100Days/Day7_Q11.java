package LeetCode100Days;

public class Day7_Q11 {
     // brute force
    public static int maxArea(int height[]){

        int n = height.length;

        // 2 for loo p

        int maxarea =0;

        for(int i=0;i<n;i++){


            for(int j =i+1;j<n;j++){
                //width

                int w = j-i;
               int minH=  Math.min(height[i],height[j] );
               //calculate area

                int area = w*minH;

                maxarea =  Math.max(maxarea,area);



            }
        }
        return maxarea;

    }

    //optimalSolution using Two pointer

    public static int OptimalSolution(int nums[]){

        int left =0,right = nums.length-1;

        int maxArea=0;

        while(left<right){
            //cal area
            int w = right-left;
            int height = Math.min(nums[left],nums[right]);
            int area = w*height;

            maxArea = Math.max(maxArea,area);

            if(nums[left]>nums[right]){
                right--;
            }else {
                left++;
            }



        }

        return maxArea;

    }


    public static void main(String[] args) {

        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
        System.out.println(OptimalSolution(nums));

    }

}
