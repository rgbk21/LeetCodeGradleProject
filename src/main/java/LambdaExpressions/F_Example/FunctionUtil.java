package LambdaExpressions.F_Example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionUtil {

    //Applies an action ot each item on a List
    public static <T> void forEachItem(List<T> list, Consumer<T> action){
        for (T item : list){
            action.accept(item);
        }
    }

    //Applies a filter to a list and returns the filtered list
    public static <T> List<T> filterItems(List<T> list, Predicate<T> predicate){

        List<T> filteredList = new ArrayList<>();

        for(T item : list){
            if(predicate.test(item)){
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    //Maps each item in the list to a value and returns the new mapped list
    public static <T,R> List<R> mapItems(List<T> list, Function<T,R> mapper){

        List<R> mappedList = new ArrayList<>();

        for(T item : list){
            mappedList.add(mapper.apply(item));
        }

        return mappedList;
    }


}
