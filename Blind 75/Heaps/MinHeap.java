import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k=2;
       System.out.println( findKthLargest(arr, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);// add first K element 
        }
        for(int i=k;i<nums.length;i++){
            if(pq.peek()<nums[i]){ // check the min element of heap is less or not then next element of array 
                pq.remove();// if yes then remove the min 
                pq.add(nums[i]);// and add the elment in heap and repeat until heap has all k  maximum elemnet of array 
            }
        }
        return pq.peek();// return the min of heap which is the kth largest element from last
    }
}
// Time Complexity: O(nlogk)
// Space Complexity: O(k)
//Problem: https://leetcode.com/problems/kth-largest-element-in-an-array/
//PriorityQueue for MaxHeap and MinHeap 
//https://www.youtube.com/watch?v=_X-_X-_X-_X&t=10s