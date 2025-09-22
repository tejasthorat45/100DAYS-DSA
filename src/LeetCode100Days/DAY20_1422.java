package LeetCode100Days;

public class DAY20_1422 {

    //Approch1

    public static int Approch1(String s){

        int res =0;
        for (int i=0;i<s.length()-2;i++){

            //find zeroa
            int zeros=0;
            for(int j=0;j<=i;j++){
                if(s.charAt(j)=='0'){
                    zeros++;

                }


            }

            //cal ones

            int ones =0;

            for (int j=i+1;j<s.length();j++){
                if(s.charAt(j)=='1'){
                    ones++;

                }
            }
            res = Math.max(res,zeros+ones);
        }
        return res;
    }

    public static int OptimalAproch(String s){

        int maxDiff =Integer.MIN_VALUE;
        int ones =0;
        int zeros =0;
        for(int i=0;i<s.length()-1;i++){

            if(s.charAt(i)=='0'){
                zeros++;
            }else{
                ones++;
            }


            maxDiff = Math.max(maxDiff,zeros-ones);
        }
        if(s.charAt(s.length()-1)=='1'){
            ones++;
        }

        return maxDiff+ones;
    }

    public static void main(String[] args) {
        String s = "1000111";
        System.out.println(Approch1(s));
        System.out.println(OptimalAproch(s));
    }
}
