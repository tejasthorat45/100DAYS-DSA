package LeetCode100Days;

import java.util.*;

public class DAY34_Q2024{

    // 🔹 Method 1: Using HashMap (translated from your C++ code)
    public int maxConsecutiveAnswers_HashMap(String answerKey, int k) {
        int result = k;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (int j = 0; j < answerKey.length(); j++) {

            char ch = answerKey.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If both T and F counts exceed k, shrink window
            while (Math.min(map.getOrDefault('T', 0), map.getOrDefault('F', 0)) > k) {
                char left = answerKey.charAt(i);
                map.put(left, map.get(left) - 1);
                i++;
            }

            result = Math.max(result, j - i + 1);
        }

        return result;
    }

    // 🔹 Method 2: Optimized version (Two-pass sliding window)
    public int maxConsecutiveAnswers_Optimized(String answerKey, int k) {
        return Math.max(
                getMaxLen(answerKey, k, 'T'),
                getMaxLen(answerKey, k, 'F')
        );
    }

    private int getMaxLen(String s, int k, char ch) {
        int left = 0;
        int count = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) != ch) count++;

            while (count > k) {
                if (s.charAt(left) != ch) count--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    // 🔹 Main method to test both approaches
    public static void main(String[] args) {
        DAY34_Q2024 sol = new DAY34_Q2024();

        String answerKey = "TTFF";
        int k = 2;

        int res1 = sol.maxConsecutiveAnswers_HashMap(answerKey, k);
        int res2 = sol.maxConsecutiveAnswers_Optimized(answerKey, k);

        System.out.println("Using HashMap approach: " + res1);
        System.out.println("Using Optimized approach: " + res2);
    }
}

