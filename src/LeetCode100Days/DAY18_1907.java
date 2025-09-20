package LeetCode100Days;

public class DAY18_1907 {
    public static String LargestOdd(String s){
        for(int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);

            if((c-'0')%2 == 1){
                return s.substring(0,i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s ="12346";
        System.out.println(LargestOdd(s));
    }



}
