package lambda;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Sample1 {
    public static void main(String[] args) {
        Sample1 main = new Sample1();
        List<Person> roster = main.fillPerson();

        //printPersonOlderThan(roster, 25);

        //printPersons(roster, new CheckPersonEligibleForSelectiveService());

        //Same example as previous one, but using lambdas
        printPersons(
            roster,
            (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 0
                && p.getAge() <= 20
        );

        

    }

    public static void printPersons(
        List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public List<Person> fillPerson() {
        List<Person> roster = new ArrayList<>();

        roster.add(new Person("Roberto", LocalDate.of(1983, Month.AUGUST, 5), Person.Sex.MALE, "email@email.com", 34));
        roster.add(new Person("Daniel", LocalDate.of(1990, Month.JANUARY, 25), Person.Sex.MALE, "test@test.com", 27));
        roster.add(new Person("Sebastian", LocalDate.of(2015, Month.MAY, 26), Person.Sex.MALE, "new@new.com", 2));
        roster.add(new Person("Santiago", LocalDate.of(2017, Month.FEBRUARY, 16), Person.Sex.MALE, "small@small.com", 0));
        roster.add(new Person("Diana", LocalDate.of(1984, Month.NOVEMBER, 23), Person.Sex.FEMALE, "a@a.com", 33));
        roster.add(new Person("Lizeth", LocalDate.of(1993, Month.JULY, 5), Person.Sex.FEMALE, "123@123.com", 24));

        return roster;
    }

    public static void printPersonOlderThan(List<Person> people, int age) {
        for (Person p : people) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }
}