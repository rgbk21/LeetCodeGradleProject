package LambdaExpressions.Example;

import java.time.LocalDate;
import java.util.List;

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
    }

}
