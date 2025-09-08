package LeetCode100Days;
//day3

public class LeetCode121 {
    public static int Aproach1(int nums[]){
        int maxprofit=0;

        for(int i=0;i< nums.length;i++){
            int profit =0;

            for (int j =i+1;j<nums.length;j++){

                profit = nums[j]-nums[i];

                maxprofit = Math.max(profit,maxprofit);
            }

        }
        if(maxprofit<0){
            return 0;
        }

        return maxprofit;

    }

    // for optimal use kadane algorith

    public static int kadanesAlgo(int prices[]){

        int minprice =Integer.MAX_VALUE;

        int maxpro =0;


        for(int i=0;i<prices.length;i++){

            if(prices[i]<minprice){
                minprice = prices[i];

            }
            int profit = prices[i]-minprice;
            maxpro = Math.max(maxpro,profit);
        }

        return maxpro;
    }

    public static void main(String[] args) {
        int nums[] ={7,1,2,3,4,8};
        //kadanealgo(int arr);

        Aproach1(nums);
        System.out.println(Aproach1(nums));
        System.out.println(kadanesAlgo(nums));
    }
}
