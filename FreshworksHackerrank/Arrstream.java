package FreshworksHackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Arrstream {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,4,5,6,7);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
int max=Arrays.stream(array).max().getAsInt();
System.out.println("\nInt stream: "+max);
// Need to be flattened to its primitive type
// stream.flatMapToInt(Arrays::stream).forEach(x -> System.out.print(x + " ");
long count=list.stream().count();
System.out.println(count);
    }
}
