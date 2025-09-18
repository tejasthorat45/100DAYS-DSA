package LeetCode100Days;

public class DAY16_Q680 {
    public static boolean isPalindrome(String s){
        int left =0;
        int right = s.length()-1;

        while(left<right){

            if(s.charAt(left)!=s.charAt(right)){
                return HelperPalindrome(s,left+1,right) || HelperPalindrome(s,left,right-1);
            }

            left++;
            right--;

        }
        return true;
    }

    private static boolean HelperPalindrome(String s, int left ,int right){
        while (left<right) {


            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(isPalindrome(s));


    }
}
