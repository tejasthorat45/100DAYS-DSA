package LeetCode100Days;

class DAY11_Q135 {

    public static int optimal(int ratings[]){
        //
        int n = ratings.length;

        int i=1;
        int candy = n;

        while(i<n){

            if(ratings[i]==ratings[i-1]){
                i++;
                continue;
            }

            //increses slope
            int peak =0;
            while(ratings[i]>ratings[i-1]){

                peak++;
                candy+=peak;
                i++;
                if(i==n){
                    return candy;
                }


            }
            //dcreseing slope
            int dip =0;
            while (i<n && ratings[i]<ratings[i-1]){
                dip++;
                candy+=dip;
                i++;

            }
            // if hit top and return to down
            candy-= Math.min(peak,dip);

        }
        return candy;

    }
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];

        // Step 1: Fill initially with 1
        for (int i = 0; i < n; i++) {
            count[i] = 1;
        }

        // Step 2: Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            }
        }

        // Step 3: Right to Left (update in place)
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                count[i] = Math.max(count[i], count[i + 1] + 1);
            }
        }

        // Step 4: Sum up
        int res = 0;
        for (int c : count) {
            res += c;
        }

        return res;
    }

    // Main function to test
    public static void main(String[] args) {
        DAY11_Q135 sol = new DAY11_Q135();

        int[] ratings1 = {1, 0, 2};
        System.out.println(sol.candy(ratings1));  // Expected output: 5

        int[] ratings2 = {1, 2, 2};
        System.out.println(sol.candy(ratings2));  // Expected output: 4

        int[] ratings3 = {1, 3, 4, 5, 2};
        System.out.println(sol.candy(ratings3));  // Expected output: 11

        int[] ratings4 = {1, 3, 4, 5, 2};
        System.out.println(optimal(ratings4));

    }
}
