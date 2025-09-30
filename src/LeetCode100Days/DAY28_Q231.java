package LeetCode100Days;

public class DAY28_Q231 {

    public static boolean solutinon(int n){

        if(n<0) return  false;
        if (n==1) {
            return true;
        } else {

            while (n%2==0){
                n= n/2;
            }

            if(n==1) {
                return true;
            }else {
                return false;
            }

        }
    }

    public static boolean ans(int n){
        return n>0 && (n&(n-1))==0;
    }

    public static void main(String args[]){

        System.out.println(solutinon(16));
        System.out.println(ans(16));

    }
}
