import java.util.*;

public class BinaryTreeWithFactors{
    public static void main(String[] args){
       int[] arr = {2,4};
       System.out.println(numFactoredBinaryTrees(arr));
    }


    public static int numFactoredBinaryTrees(int[] arr) {
        //sort the arr first 
        int MOD=1000000007;
         Arrays.sort(arr);
        HashMap<Integer,Long>map=new HashMap<Integer,Long>(); // declare map 
        long ans=1;
        map.put(arr[0],ans); //key=2,vaule=1;
        for(int i=1;i<arr.length;i++)//i=1
        {
            long sum=1;
            for(int j=0;j<i;j++)//j=0
            {
                if(arr[i]%arr[j]==0 &&map.containsKey(arr[i]/arr[j]))
                    //(4%2==0&&keyinmap(4/2=2))ture
                    sum+=(map.get(arr[i]/arr[j])*map.get(arr[j]));//sum=(1*1)+1=2
            }
            map.put(arr[i],sum);//key=4,2
            ans+=sum;//3
        }
        return (int)(ans%MOD);//3%MOD
}
}