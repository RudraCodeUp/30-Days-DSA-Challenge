import java.util.*;
// Approach: Using HashSet to find longest consecutive sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        int longest = 0;

        for (int num : numSet) {
            // only start counting if it's the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
