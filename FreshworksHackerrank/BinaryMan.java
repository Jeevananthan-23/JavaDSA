package FreshworksHackerrank;

public class BinaryMan {
   public static void main(String[] args) {
        int n=13;
        int result=minimumOneBitOperations(n);
        System.out.println(result);
    }
    public static  int minimumOneBitOperations(int n) {
        int sign = 1, res = 0;
        if(n==0) return 0;
         while (n > 0) {
             res += n ^ (n - 1) * sign;
             n &= n - 1;
             sign = -sign;
         }
         return Math.abs(res); 
     }
}
