//find the largest possible total sum of the volume for the given stack of cubes.
//The stack is represented by a list of non-negative integers, which is sorted in ascending order.
//The list is not necessarily sorted in ascending order.
//The total volume of a cube is the volume of the cube multiplied by the number of cubes of that volume.
//You may assume that all cubes are of the same volume.
//Example 1:
//Input: [1,2,3,4,5,6,7,8,9,10]
//Output: 50000
//Explanation:
//There are 5 cubes of volume 1, 2, 3, 4, 5 respectively.
//There are 5 cubes of volume 2, 4, 6, 8, 10 respectively.
//There are 5 cubes of volume 3, 6, 9, 12, 15 respectively.
//There are 5 cubes of volume 4, 8, 12, 16, 20 respectively.
//There are 5 cubes of volume 5, 10, 15, 20, 25 respectively.
//The total volume of these 5 cubes is 50000.
//Example 2:
//Input: [4,1,2,3]
//Output: 24
//Explanation:
//There are 2 cubes of volume 4, 1, and 2.
//There are 3 cubes of volume 1, 2, and 3.
//The total volume of these 5 cubes is 24.
//Note:
//1 <= N <= 50
//1 <= volume of cube <= 1000
//The total number of cubes in this problem does not exceed 50000.
public class StackCube {
    public static void main(String[] args) {
        int[] arr = {1,2,4,3};
        System.out.println(maxVolume(arr));
    }
    public static int maxVolume(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + A[i];
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i] + dp[i - 1]);
        }
        return max;
    }
}
//