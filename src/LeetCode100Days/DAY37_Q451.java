package LeetCode100Days;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DAY37_Q451 {

    public static String sortByFreq(String s){

        //step 1-> freq count

        Map<Character,Integer> freqmap = new HashMap<>();

        for(char c : s.toCharArray()){
            freqmap.put(c,freqmap.getOrDefault(c,0)+1);
        }
        //step 2 ->>>> define maxHeap

        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>(
                (a,b)-> b.getValue()-a.getValue());

        maxHeap.addAll(freqmap.entrySet());

        //build res

        StringBuilder res = new StringBuilder();


        while (!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> entry = maxHeap.poll();

            char c = entry.getKey();
            int freq = entry.getValue();

            for(int i=0;i<freq;i++){
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "tree";

        System.out.println(sortByFreq(s));
    }
}
