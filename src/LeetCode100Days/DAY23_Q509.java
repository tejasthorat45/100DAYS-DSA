package LeetCode100Days;

public class DAY23_Q509 {

    //fbonaci number

    public static int fibonacciNo(int num){

        //base cses
        if(num<2) return num;

        int a =0;
        int b=1;
        int sum=0;

        for(int i=2;i<=num;i++){

            sum = a+b;
            a=b;
            b=sum;
        }

        return sum;

    }

    //USING RECURSION

    public static int fibonaci(int n){

        if(n==0) return 0;
        if (n==1) return 1;

        return fibonaci(n-1)+fibonaci(n-2);
    }

    public static void main(String[] args) {

        System.out.println(fibonacciNo(4));
        System.out.println(fibonacciNo(1));
        System.out.println(fibonaci(4));

    }
}
