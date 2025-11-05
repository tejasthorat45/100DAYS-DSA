package LeetCode100Days;

public class DAY57_PowerXn {

    private static int power(int x, int n){

        //base cse

        if(n==0) return 1;

        return x*power(x,n-1);

    }

    public static int optimize(int a, int n){

        //base case
        if(n==0) return 1;

        int halfpower = optimize(a,n/2);

        int halfpowersquare = halfpower*halfpower;

        if(n%2!=0) {
            halfpowersquare=a*halfpowersquare;
        }

        return halfpowersquare;
    }

    public static void main(String[] args) {
        System.out.println(power(2,5));
        System.out.println(optimize(2,5));
    }
}
