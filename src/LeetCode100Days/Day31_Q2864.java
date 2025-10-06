package LeetCode100Days;

public class Day31_Q2864 {

    public static String oddBinaryNumber(String s){

        int n =s.length();
        StringBuilder  res = new StringBuilder();

        for(int i=0;i<n;i++){

            res.append("0");

        }

        int j =0;

        for(char c : s.toCharArray()){

            if(c=='1'){
                if (res.charAt(n-1)=='1'){
                    res.setCharAt(j,'1');
                }else{
                    res.setCharAt(n-1,'1');
                }
            }
        }

        return res.toString();

    }

    public static void main(String[] args) {
        String s = "1010";
        System.out.println(oddBinaryNumber(s));


    }
}
