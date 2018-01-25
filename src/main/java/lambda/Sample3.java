package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Sample3 {
    public static void main(String[] args) {
        /*** Lambda samples with Functional Interfaces  ***/

        //Sample with no parameter
        MyFunctionalInterface msg = () -> {return "Sample 1 - No parameter: Hello";};
        System.out.println(msg.sayHello());

        //Sample with one parameter
        MyFunctionalInterface2 f = (num) -> num + 5;
        System.out.println("Sample 2 - One parameter: Result: " + f.incrementByFive(8));

        //Sample with multiple parameters
        MyFunctionalInterface3 name = (a, b) -> a + " " + b;
        System.out.println("Sample 3 - Multiple parameters: " + name.sayHello("Roberto","Guerrero"));

        //Iterating collections
        List<String> list = new ArrayList<>();
        list.add("Santiago");
        list.add("Sebastian");
        list.add("Diana");
        list.add("Roberto");

        System.out.print("Sample 4 - Iterating collection: ");
        list.forEach(
            (names) -> System.out.print(names + ", ")
        );
        System.out.println();



        /*** Lambda samples with Predefined Functional Interfaces  ***/
        List<String> players = new ArrayList<>();
        players.add("Rafael Nadal");
        players.add("Novak Djokovic");
        players.add("David Ferrer");
        players.add("Roger Federer");

        //Consumer example - Single input with no return result
        System.out.print("Sample 5 - Consumer predefined: ");
        players.forEach((player) -> System.out.print(player + ", "));

        System.out.println();

        //Function example - Accepts one argument and produces a result
        System.out.print("Sample 6 - Function predefined: ");
        Function<List<String>, String> converter = (all) -> {
            String names = "";
            for (String n : all) {
                String forname = n.substring(0, n.indexOf(" "));
                forname = n.substring(n.indexOf(" ")) + " " + forname;
                names+=forname + ", ";
            }
            return names;
        };
        System.out.println(converter.apply(players));

        //Predicate example - Represents a predicate, (boolean based) of one argument
        System.out.println("Sample 7 - Predicate predefined: " + getBeginWith(players, (p) -> p.startsWith("R")));

        //Supplier example - Represents a supplier of results
        listBeginWith(players, (p) -> p.endsWith("r"));

        //Comparator example - Compare two arguments for order. Negative, zero and positive results for ordering.
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Roberto"));
        personList.add(new Person("Sebastian"));
        personList.add(new Person("Santiago"));
        personList.add(new Person("Diana"));

        Collections.sort(personList,
            (Person p1, Person p2) -> p1.getName().compareTo(p2.getName())
        );
        System.out.print("Sample 8 - Compare predefined: " );
        personList.forEach(person -> System.out.print(person.getName() + ", "));
    }

    private static List getBeginWith(List<String> list, Predicate<String> valid) {
        List<String> selected = new ArrayList<>();
        list.forEach(player ->{
            if (valid.test(player)) {
                selected.add(player);
            }
        });
        return selected;
    }

    private static void printNames(Supplier<String> arg) {
        System.out.print(arg.get());
    }

    private static void listBeginWith(List<String> list, Predicate<String> valid) {
        printNames(() -> "Sample 8 - Supplier predefined: ");
        list.forEach(player -> {
            if (valid.test(player)) {
                printNames(() -> player + ", ");
            }
        });
        System.out.println();
    }
}
