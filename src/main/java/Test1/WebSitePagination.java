package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebSitePagination {

    public static void main(String[] args) {

    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items,
                                                   int sortParameter,
                                                   int sortOrder,
                                                   int itemsPerPage,
                                                   int pageNumber) {



        items.sort((list1, list2) -> {
            if (list1.get(sortParameter).compareTo(list2.get(sortParameter)) > 0) {
                return 1;
            } else if (list1.get(sortParameter).compareTo(list2.get(sortParameter)) < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        if (sortOrder == 1) {
            Collections.reverse(items);
        }

        int startIdx = itemsPerPage * pageNumber;
        List<String> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + itemsPerPage && i < items.size(); i++) {
            result.add(items.get(i).get(0));

        }

        return result;


    }

}
