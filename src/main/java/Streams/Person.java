package Streams;

import com.google.common.base.MoreObjects;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Person {

    public static enum Gender {MALE, FEMALE}

    private long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;
    private double income;

    public Person(long id, String firstName, String lastName, Gender gender, LocalDate dateOfBirth,  double income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("dateOfBirth", dateOfBirth)
                .add("gender", gender)
                .add("income", income)
                .toString();
    }

    // A utility method
    public static List<Streams.Person> getPersons() {

        Person ken = new Person(1, "Ken", "" , Gender.MALE, LocalDate.of(1970, Month.MAY, 4), 6000.0);
        Person jeff = new Person(2, "Jeff", "" , Gender.MALE, LocalDate.of(1970, Month.JULY, 15), 7100.0);
        Person donna = new Person(3, "Donna", "" , Gender.FEMALE, LocalDate.of(1962, Month.JULY, 29), 8700.0);
        Person chris = new Person(4, "Chris","" , Gender.MALE, LocalDate.of(1993, Month.DECEMBER, 16), 1800.0);
        Person laynie = new Person(5, "Laynie", "" , Gender.FEMALE, LocalDate.of(2012, Month.DECEMBER, 13), 0.0);
        Person lee = new Person(6, "Li", "" ,Gender.MALE, LocalDate.of(2001, Month.MAY, 9), 2400.0);

        // Create a list of persons
        List<Person> persons = Arrays.asList(ken, jeff, donna, chris, laynie, lee);

        return persons;
    }
}
