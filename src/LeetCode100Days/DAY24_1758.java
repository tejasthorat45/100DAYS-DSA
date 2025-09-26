package LeetCode100Days;

public class DAY24_1758 {

    public static int minChanges(String s){

        int n = s.length();
        int s_with_1=0;
        int s_with_0 =0;

        for (int i=0;i<n;i++){

            //cal for even idx

            if (i%2==0){
                //even

                if(s.charAt(i)=='0'){
                    //for 1010
                    s_with_1++;

                }else{
                    //010101
                    s_with_0++;
                }
            }else {

                if(s.charAt(i)=='0'){
                    //0101
                    s_with_1++;
                }else{
                    s_with_0++;
                }

            }


        }
        return Math.min(s_with_0,s_with_1);
    }

    public static void main(String[] args) {
        String s ="10100101";
        System.out.println(minChanges(s));


    }
}
