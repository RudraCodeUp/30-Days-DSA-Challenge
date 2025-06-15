import java.util.*;
// Approach: Using HashMap and Min Heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // Step 2: Use min heap to keep top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll(); // remove least frequent
        }

        // Step 3: Extract elements from heap
        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty())
            result[i++] = minHeap.poll().getKey();

        return result;
    }
}

