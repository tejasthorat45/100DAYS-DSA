package LeetCode100Days;

public class DAY16_Q125 {
    public static boolean brute(String s){

        StringBuilder sb = new StringBuilder("");
       //apend
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        String revStr = sb.reverse().toString();
        String str = sb.toString();
        return revStr.equals(str);

    }

    public static boolean OptimalTwoptr(String s){

        int left =0 , right = s.length()-1;

        while (left<right){

            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;


        }
        return true;
    }
    public static void main(String[] args) {
        String s = "race car,";
        System.out.println(brute(s));
        System.out.println(OptimalTwoptr(s));
        
    }
}
