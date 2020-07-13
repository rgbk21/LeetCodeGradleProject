package LambdaExpressions.F_Example;

import java.util.List;
import java.util.function.Supplier;

public class FunctionUtilTest {

    public static void main(String[] args) {

        List<Person> personsList = Person.getPersons();

        //Use the forEachItem method to print the list of persons
        FunctionUtil.forEachItem(personsList, person -> System.out.println(person));

        //Filter only males
        System.out.println("\nFilter only males");
        List<Person> onlyMales = FunctionUtil.filterItems(personsList, person -> person.getGender()==Gender.MALE);
        //and then print the list of the males
        FunctionUtil.forEachItem(onlyMales, person -> System.out.println(person));

        //Map each person to his/her year of birth
        System.out.println("\nMap each person to his/her year of birth");
        List<Integer> dateOfBirths = FunctionUtil.mapItems(personsList, person -> person.getDateOfBirth().getYear());
        FunctionUtil.forEachItem(dateOfBirths, year -> System.out.println(year));

        //Apply an action to each person in the list
        //Add one year to each MALE's DOB
        //Just in case you've forgotten - persons are being passed by reference. So the changed year of birth for males
        //will also be visible in the personsList along withe the onlyMales list.
        FunctionUtil.forEachItem(onlyMales, person -> person.setDateOfBirth(person.getDateOfBirth().plusYears(1)));
        System.out.println("\nMales only after adding 1 year to DOB:");
        FunctionUtil.forEachItem(personsList, p -> System.out.println(p));

        //getPersons is a static method, and hence can be also written using a method reference
        //Method signature of getPersons is: public static List<Person> getPersons()
        //So it takes no arguments as input and returns a List<Person>
        System.out.println("\nUsing a method reference to generate the list");
        Supplier<List<Person>> listOfPersons = Person::getPersons;
        List<Person> personList = listOfPersons.get();
        FunctionUtil.forEachItem(personList, p -> System.out.println(p));

        //Writing the same thing using the lambda expression would be
        System.out.println("\nUsing a lambda expression to generate the list");
        Supplier<List<Person>> listSupplier = () -> Person.getPersons();
        List<Person> personList2 = listSupplier.get();
        FunctionUtil.forEachItem(personList, p -> System.out.println(p));
    }
}
