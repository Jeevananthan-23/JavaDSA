package Normalprgms;
import java.util.Arrays;
import java.util.Scanner;


public class NotEqual {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int Q= sc.nextInt();
        
        int[] query= new int[Q];
        for(int i=0;i<Q;i++){
            query[i]=sc.nextInt();
        }
      int resut=  notEqual(  Q, query);
      System.out.println(resut);
    }

    private static int notEqual( int q, int[] query) {
        int result=1;
        Arrays.sort(query);
    for (int i = 0; i < q; i++) {
      if (query[i] == result)
        result++;
    }
        return result;
    }
}
