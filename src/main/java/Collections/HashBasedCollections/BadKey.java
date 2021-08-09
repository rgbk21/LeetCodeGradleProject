package Collections.HashBasedCollections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class TestClass {

    public static void main(String[] args) {

        // Let us create a HashSet where we are storing BadKey objects
        Set<BadKey> badKeys = new HashSet<>();
        BadKey badKey1 = new BadKey(100);
        BadKey badKey2 = new BadKey(300);
        // Add two objects to the set
        badKeys.add(badKey1);
        badKeys.add(badKey2);
        // Check if badKey2 exists in the set
        System.out.println("badKeys: " + badKeys); // badKeys: [BadKey{id=100}, BadKey{id=300}]
        System.out.println("badKeys contains badKey2: " + badKeys.contains(badKey2)); // true

        // Mutate the badKey2
        badKey2.setId(200);
        System.out.println("badKeys: " + badKeys); // badKeys: [BadKey{id=100}, BadKey{id=200}]
        System.out.println("badKeys contains badKey2: " + badKeys.contains(badKey2)); // false
    }
}

public class BadKey {

    private int id;

    public BadKey(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public BadKey setId(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadKey badKey = (BadKey) o;
        return id == badKey.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BadKey{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

class AnotherBadKey {

    private int id;
    private String name;

    public AnotherBadKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public AnotherBadKey setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnotherBadKey setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherBadKey that = (AnotherBadKey) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class OneMoreBadKey {

    private String name;

    public String getName() {
        return name;
    }

    public OneMoreBadKey setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneMoreBadKey that = (OneMoreBadKey) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class TwoMoreBadKey {

    private String firstName;
    private String lastName;

    public TwoMoreBadKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public TwoMoreBadKey setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoMoreBadKey that = (TwoMoreBadKey) o;
        return firstName.equals(that.firstName) && lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public TwoMoreBadKey setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}