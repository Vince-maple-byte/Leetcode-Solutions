//Solution for 347. Top K Frequent Elements
//Time complexity O(n log(k))
//Space complexity O(n)

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
             (a, b) ->
            a.getValue() - b.getValue()
        );
        int[] result = new int[k];
        for(int i = 0; i < nums.length; i++){
            if(!freq.containsKey(nums[i])){
                freq.put(nums[i], 1);
            }
            else{
                freq.put(nums[i], freq.get(nums[i]) + 1);
            }
            System.out.println(nums[i] + ": "+freq.get(nums[i]));
        }

        for(Map.Entry<Integer, Integer> it : freq.entrySet()){
            pq.add(it);
            if(pq.size() > k) pq.poll();
        }
        int index = 0;
        while(!pq.isEmpty()){
            result[index++] = pq.poll().getKey();
        }
        return result;
    }

    
}