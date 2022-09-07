public class TwoSum2 {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] res = twoSum(nums,target);
        System.out.println(res[0]+" "+res[1]);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            else if(numbers[i]+numbers[j]<target){
                i++;
            }
            else{
                j--;
            }
        }
        return new int[]{-1,-1};
    }
}
