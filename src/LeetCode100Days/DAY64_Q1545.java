package LeetCode100Days;

public class DAY64_Q1545 {

    public static void main(String[] args) {
        System.out.println(findkthbit(4,11));
    }

    private static char findkthbit(int n, int k) {

        //base csaesae

        if(n==1) return '0';

        int len = (int) (Math.pow(2,n)-1);

        if(k<Math.ceil(len/2.0)){
            return findkthbit(n-1,k);
        } else if (k==Math.ceil(len/2.0)) {

            return '1'; // middle elemnt is always 1

        }else{
            //k>len/2;

            char ch = findkthbit(n-1,len-(k-1));

            return (ch=='0')?'1':'0';

        }
    }
}
