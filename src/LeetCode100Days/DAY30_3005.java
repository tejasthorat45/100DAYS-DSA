package LeetCode100Days;

public class DAY30_3005 {

    public static int usingOnePass(int nums[]){
        int freq[] = new int[101];

        int maxfreq =0;

        for(int num: nums){

            freq[num]++;
            maxfreq= Math.max(maxfreq,freq[num]);

        }
        int res =0;
        for(int i=0;i<101;i++){

            if(freq[i]==maxfreq){
                res+=maxfreq;
            }
        }

        return res;
    }

    public static int onePass(int nums[]){

        int maxfreq =0;
        int total =0;
        int count[]= new int[101];
        for(int num:nums){

            count[num]++;

            int freq = count[num];
            if(freq>maxfreq){
                maxfreq=freq;
                total=maxfreq;
            } else if (freq==maxfreq) {
                total+=maxfreq;

            }


        }

        return total;
    }

    public static void main(String[] args) {
        int arr[]= {1,2,2,1,4};
        System.out.println(usingOnePass(arr));
        System.out.println(onePass(arr));

    }
}
