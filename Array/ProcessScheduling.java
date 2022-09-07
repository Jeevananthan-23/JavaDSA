package Array;

//Process Scheduling with n=5(number of processors and size of ability[]) ability=[3,1,7,2,4] processes=15 find the minimum time to complete all the processes
public class ProcessScheduling {
    public static void main(String[] args) {
        int[] ability={3,1,7,2,4};
        int processes=15;
        int res=findMinTime(ability,processes);
       System.out.println(res);

    }
    public static int findMinTime(int[] ability,int processes){

        int n=ability.length;
        int[][] dp=new int[n][processes+1];
        for(int i=0;i<n;i++){
            dp[i][0]=0;
        }
        for(int i=1;i<=processes;i++){
            dp[0][i]=i*ability[0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=processes;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=ability[i]){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-ability[i]]+ability[i]);
                }
            }
        }
        return dp[n-1][processes];
    }
}
