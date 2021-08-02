package Collections.Sets;

import java.util.*;

public class TreeSetTest {

    public static void main(String[] args) {

        // The idea of doing the same thing two different ways is to try and understand what is going on
        // in the Comparator for the first employees1 set.

        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bob", 2);
        Person p3 = new Person("Charlie", 3);
        Person p4 = new Person("Dave", 4);
        Person p6 = new Person("Dave", 6);
        Person p5 = new Person("Alice", 5);
        Person p7 = new Person("Alice", 5); // Duplicate. Should not be present in set.
        List<Person> people = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));

        // Note how we can chain the comparing
        SortedSet<Person> employees1 = new TreeSet<>(Comparator.comparing(Person::getName).thenComparing(Person::getId));
        employees1.addAll(people);
        System.out.println("After sorting by the name and then the id: " + employees1);
        // After sorting by the name and then the id:
        // [Person{name='Alice', id=1}, Person{name='Alice', id=5}, Person{name='Bob', id=2}, Person{name='Charlie', id=3}, Person{name='Dave', id=4}, Person{name='Dave', id=6}]



        Comparator<Person> personComparator = (person1, person2) -> {
            if (person1.getName().compareTo(person2.getName()) > 0) {
                return 1;
            } else if (person1.getName().compareTo(person2.getName()) < 0) {
                return -1;
            } else {
                // This entire block can be replaced just by this one single line:
                // return Integer.compare(person1.getId(), person2.getId());
                if (person1.getId() > person2.getId()) {
                    return 1;
                } else if (person1.getId() < person2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        SortedSet<Person> employees2 = new TreeSet<>(personComparator);
        employees2.addAll(people);
        System.out.println("After sorting by the name and then the id: " + employees2);
        // Same result as the above case. Atleast that is what we were expecting
        // After sorting by the name and then the id:
        // [Person{name='Alice', id=1}, Person{name='Alice', id=5}, Person{name='Bob', id=2}, Person{name='Charlie', id=3}, Person{name='Dave', id=4}, Person{name='Dave', id=6}]

        // Incorporating the null check as well
        Person p8 = null; // Time to blow stuff up
        people.add(p8);
        SortedSet<Person> employees3 = new TreeSet<>(Comparator.nullsFirst(personComparator));
        employees3.addAll(people);
        System.out.println("After sorting by the name and then the id: " + employees3);
        // After sorting by the name and then the id:
        // [null, Person{name='Alice', id=1}, Person{name='Alice', id=5}, Person{name='Bob', id=2}, Person{name='Charlie', id=3}, Person{name='Dave', id=4}, Person{name='Dave', id=6}]

    }

}

class Person {

    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
