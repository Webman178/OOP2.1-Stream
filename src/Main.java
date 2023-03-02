import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<Optional<T>, Optional<T>> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        Optional<T> min = Optional.of(Collections.min(list,order));
        Optional<T> max = Optional.of(Collections.max(list,order));
        /*stream.sorted(order).collect(Collectors.toList());

        if(list.isEmpty())
            minMaxConsumer.accept(null, null);
        else
            minMaxConsumer.accept(list.get(0),list.get(list.size()-1));*/

        minMaxConsumer.accept(min,max);
    }

    public static void findEvenNumbers(List<Integer> list3) {
        List <Integer> list4 = list3.stream().filter(x -> (x%2 == 0)).sorted().collect(Collectors.toList());
        System.out.println(list4);
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 9, 14, 4};
        Stream<Integer> stream1 =Arrays.stream(arr);
        Comparator <Integer> compar1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return -1;
                if (o1 > o2) {
                    return 1;
                }
                return 0;
            }

        };
        BiConsumer <Optional<Integer>,Optional<Integer>> bicons = (x,y) -> {
            System.out.println(x + " " + y);
        };
        findMinMax(stream1,compar1,bicons);

        System.out.println("------------------------------");

        Integer[] arr2 = {1, 2, 3, 4};
        List<Integer> list2 = Arrays.asList(arr2);
        findEvenNumbers(list2);

    }
}