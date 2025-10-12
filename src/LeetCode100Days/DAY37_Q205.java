package LeetCode100Days;

import java.util.*;

public class DAY37_Q205 {

    // Method to check if two strings are isomorphic
    public static boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check mapping from s -> t
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                mapST.put(c1, c2);
            }

            // Check mapping from t -> s
            if (mapTS.containsKey(c2)) {
                if (mapTS.get(c2) != c1) return false;
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    // Main method to test
    public static void main(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        System.out.println(s1 + " & " + t1 + " -> " + isIsomorphic(s1, t1)); // true

        String s2 = "foo";
        String t2 = "bar";
        System.out.println(s2 + " & " + t2 + " -> " + isIsomorphic(s2, t2)); // false

        String s3 = "paper";
        String t3 = "title";
        System.out.println(s3 + " & " + t3 + " -> " + isIsomorphic(s3, t3)); // true

        String s4 = "ab";
        String t4 = "aa";
        System.out.println(s4 + " & " + t4 + " -> " + isIsomorphic(s4, t4)); // false
    }
}


