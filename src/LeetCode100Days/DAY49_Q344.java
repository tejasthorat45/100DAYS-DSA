package LeetCode100Days;

public class DAY49_Q344 {

    public char[] reverseString1(char[] s){

        int n = s.length;

        int left=0;
        int right =n-1;

        while(left<right){
            char temp = s[left];
            s[left]= s[right];
            s[right]=temp;
            left++;
            right--;

        }

        return s;
    }

    public char[] reverseString(char s[]){

        String str = new String(s);

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        for (int i=0;i<s.length;i++){
            s[i]=sb.charAt(i);


        }

        return s;

    }

    public static void main(String[] args) {
        char s[]={'a','b','c'};
        DAY49_Q344 obj = new DAY49_Q344();
        System.out.println(obj.reverseString(s));

        char t[]={'a','b','c'};
        System.out.println(obj.reverseString1(t));

    }
}
