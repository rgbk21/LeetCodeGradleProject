package Test1.RandomStuff;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        List<String> strList = new ArrayList<>();
        strList.add("asd");
        strList.add("atada");
        strList.add("werwer");

        sortStringBySecondCharacter(strList);

    }

    public static void sortStringBySecondCharacter(List<String> strList) {

        // [asd, asada, werwer]

        strList.sort((str1, str2) -> {
            if (str1.charAt(1) > str2.charAt(1)) {
                return 1;
            } else if (str1.charAt(1) < str2.charAt(1)) {
                return -1;
            } else {
                return 0;
            }
        });

        System.out.println(strList);

    }

}
