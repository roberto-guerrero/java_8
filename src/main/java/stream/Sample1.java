package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sample1 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<Integer>();
        for (int i=0; i<100; i++) {
            myList.add(i);
        }

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();


        //Parallel
        Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
        highNums.forEach(p -> System.out.println("High Nums Parallel: " + p));

        //Sequential
        Stream<Integer> highNumSeq = sequentialStream.filter(p -> p > 90);
        highNumSeq.forEach(p -> System.out.println("High Nums Sequetial: " + p));

    }
}
