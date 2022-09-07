import java.util.*;

public class TopFeqElement {
    //top k frequent element in an array
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                        return b.getValue() - a.getValue();
                    }
                });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
    //top k frequent element in an array bukcet sort
    public int[] topKFrequentBucketSort(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[] bucket = new int[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()]++;
        }
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            for (int j = 0; j < bucket[i]; j++) {
                result[index++] = i;
            }
        }
        return result;
    }
}
