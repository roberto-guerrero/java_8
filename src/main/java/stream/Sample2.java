package stream;

import lambda.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Roberto", "Sebastian", "Santiago", "Diana");
        System.out.println("Sample 1 (Original): " + names);

        System.out.print("Sample 1 (Filtered): ");
        names.stream()
            .filter((n) -> n.startsWith("S"))
            .map(String::toLowerCase)
            .sorted()
            .map(n -> n + ", ")
            .forEach(System.out::print);
        System.out.println();

        System.out.print("Sample 2: ");
        Arrays.asList("a1","a2","a3")
            .stream()
            .findFirst()
            .ifPresent(System.out::println);

        System.out.print("Sample 3: ");
        Stream.of("Horse","Cat","Doc","Fish","Bird")
            .filter(n -> n.length() >= 4)
            .sorted()
            .map(n -> n + ", ")
            .forEach(System.out::print);
        System.out.println();

        System.out.print("Sample 4: ");
        IntStream.range(1,10)
            .mapToObj(i -> i + ", ")
            .forEach(System.out::print);
        System.out.println();


        System.out.print("Sample 5: ");
        List<Person> persons = Arrays.asList(
            new Person("Roberto", 34),
            new Person("Sebastian", 2),
            new Person("Diana", 34),
            new Person("Santiago", 0),
            new Person("Aurora", 2),
            new Person("Linda", 34));

        Map<Integer, List<Person>> personsByAge = persons.stream()
            .collect(Collectors.groupingBy(p -> p.getAge()));

        personsByAge.forEach((age, name) -> System.out.println("Age: " + age + ", Names: " + name));

    }
}
