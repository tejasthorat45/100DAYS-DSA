package LeetCode100Days;

public class DAY14_Q151 {


        public static String reverseWords(String s) {

            String words[] = s.trim().split("\\s+");

            StringBuilder sb = new StringBuilder();

            for(int i=words.length-1;i>=0;i--){

                sb.append(words[i]);

                if(i!=0){
                    sb.append(" ");
                }


            }

            return sb.toString();


        }

    public static void main(String[] args) {
        String str = "The Sky Is Blue";
        System.out.println(reverseWords(str));

    }

}
