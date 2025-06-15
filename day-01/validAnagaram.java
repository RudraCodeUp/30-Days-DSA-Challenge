import java.util.*;

// Approach 1: HashMap - Time: O(n), Space: O(1) - at most 26 characters
public class validAnagaram {
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            Map<Character,Integer> amap = new HashMap<>();
            Map<Character,Integer> bmap = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                amap.put(s.charAt(i), amap.getOrDefault(s.charAt(i), 0) + 1);
                bmap.put(t.charAt(i), bmap.getOrDefault(t.charAt(i), 0) + 1);
            }
            return amap.equals(bmap);
        }
        else{
            return false;
        }
    }
}

// Approach 2: Sorting - Time: O(n log n), Space: O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}

// Approach 3: Character Count Array - Time: O(n), Space: O(1)
class Sol {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }
}

// Approach 4: Single HashMap - Time: O(n), Space: O(1)
class Solution4 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        // Count characters in first string
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // Subtract characters from second string
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        
        return map.isEmpty();
    }
}


