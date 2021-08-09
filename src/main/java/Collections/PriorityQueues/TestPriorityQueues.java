package Collections.PriorityQueues;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class TestPriorityQueues {

    public static void main(String[] args) {

        // Priority Queue using a Comparable
        Queue<ComparablePerson> peopleQueue = new PriorityQueue<>();
        peopleQueue.offer(new ComparablePerson(1, "John"));
        peopleQueue.offer(new ComparablePerson(4, "Ken"));
        peopleQueue.offer(new ComparablePerson(2, "Richard"));
        peopleQueue.offer(new ComparablePerson(3, "Donna"));
        peopleQueue.offer(new ComparablePerson(4, "Adam"));

        System.out.println("Priority queue: " + peopleQueue);
        // [Person{id=1, name='John'}, Person{id=3, name='Donna'}, Person{id=2, name='Richard'}, Person{id=4, name='Ken'}, Person{id=4, name='Adam'}]

        // Removing elements from the PriorityQueue
        System.out.println(peopleQueue.poll()); // Person{id=1, name='John'}
        System.out.println(peopleQueue.poll()); // Person{id=2, name='Richard'}
        System.out.println(peopleQueue.poll()); // Person{id=3, name='Donna'}
        System.out.println(peopleQueue.poll()); // Person{id=4, name='Adam'}
        System.out.println(peopleQueue.poll()); // Person{id=4, name='Ken'}
        System.out.println(peopleQueue.poll()); // null

        // PriorityQueue using a Comparator
        // Note how we are able to use a Comparator on a class that is already implementing the Comparable interface
        // but we have managed to assign priority to its elements using a custom Comparator that we have passed.
        // Now the priority queue is based on the lexical names now.
        Queue<ComparablePerson> comparatorQueue = new PriorityQueue<>(Comparator.comparing(ComparablePerson::getName));
        comparatorQueue.offer(new ComparablePerson(1, "John"));
        comparatorQueue.offer(new ComparablePerson(4, "Ken"));
        comparatorQueue.offer(new ComparablePerson(2, "Richard"));
        comparatorQueue.offer(new ComparablePerson(3, "Donna"));
        comparatorQueue.offer(new ComparablePerson(4, "Adam"));

        System.out.println("Priority queue: " + comparatorQueue);
        // [Person{id=4, name='Adam'}, Person{id=3, name='Donna'}, Person{id=2, name='Richard'}, Person{id=4, name='Ken'}, Person{id=1, name='John'}]
        System.out.println(comparatorQueue.poll()); // Person{id=4, name='Adam'}
        System.out.println(comparatorQueue.poll()); // Person{id=3, name='Donna'}
        System.out.println(comparatorQueue.poll()); // Person{id=1, name='John'}
        System.out.println(comparatorQueue.poll()); // Person{id=4, name='Ken'}
        System.out.println(comparatorQueue.poll()); // Person{id=2, name='Richard'}
        System.out.println(comparatorQueue.poll()); // null
    }
}

class ComparablePerson extends Person implements Comparable<ComparablePerson> {

    public ComparablePerson(int id, String name) {
        super(id, name);
    }

    @Override
    public int compareTo(ComparablePerson o) {
        ComparablePerson otherPerson = (ComparablePerson) o;
        int otherPersonId = otherPerson.getId();
        String otherPersonName = otherPerson.getName();
        if (this.getId() > otherPersonId) {
            return 1;
        } else if (this.getId() < otherPersonId) {
            return -1;
        } else {
            return this.getName().compareTo(otherPersonName);
        }
    }

//    @Override
//    public int compareTo(Person o) {
//        ComparablePerson otherPerson = (ComparablePerson) o;
//        int otherPersonId = otherPerson.getId();
//        String otherPersonName = otherPerson.getName();
//        if (this.getId() > otherPersonId) {
//            return 1;
//        } else if (this.getId() < otherPersonId) {
//            return -1;
//        } else {
//            return this.getName().compareTo(otherPersonName);
//        }
//    }

//    @Override
//    public int compareTo(Object o) {
//        ComparablePerson otherPerson = (ComparablePerson) o;
//        int otherPersonId = otherPerson.getId();
//        String otherPersonName = otherPerson.getName();
//        if (this.getId() > otherPersonId) {
//            return 1;
//        } else if (this.getId() < otherPersonId) {
//            return -1;
//        } else {
//            return this.getName().compareTo(otherPersonName);
//        }
//    }
}

class Person {

    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
