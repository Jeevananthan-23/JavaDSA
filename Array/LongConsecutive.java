package Array;
import java.util.*;
public class LongConsecutive {
    
    public static int longestConsecutive(int[] nums) {
        int max = 0;
  
  Set<Integer> set = new HashSet<>();
  for (int i = 0; i < nums.length; i++) {
    set.add(nums[i]);
  }
  
  for (int i = 0; i < nums.length; i++) {
    int count = 1;
    
    // look left
    int num = nums[i];
    while (set.contains(--num)) {
      count++;
      set.remove(num);
    }
    
    // look right
    num = nums[i];
    while (set.contains(++num)) {
      count++;
      set.remove(num);
    }
    
    max = Math.max(max, count);
  }
  
  return max;
     }

     public static void main(String[] args){
        int arr[]= {-5,3,9,4};
       // int longCon= longestConsecutive(arr);
        getGrossValue(arr);
       // System.out.println(longCon);
     }

//find out the gross value of the any valid triplet in the array
    public static void getGrossValue(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                for(int k=j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k]>max){
                        max=arr[i]+arr[j]+arr[k];
                    }
                }
            }
        }
        System.out.println(max);
    }
}

//Eliminate substring from a string after removing all the duplicate characters
//https://www.geeksforgeeks.org/eliminate-substring-from-a-string-after-removing-all-the-duplicate-characters/



//MergeSort count the number of inversions in an array  of size n
//https://www.geeksforgeeks.org/counting-inversions/


// Time Complexity: O(n^2)