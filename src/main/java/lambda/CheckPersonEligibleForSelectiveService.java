package lambda;

public class CheckPersonEligibleForSelectiveService implements CheckPerson{
    public boolean test(Person p) {
        return p.gender == Person.Sex.MALE &&
            p.getAge() >= 0 &&
            p.getAge() <= 20;
    }
}
