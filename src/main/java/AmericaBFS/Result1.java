package AmericaBFS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Result1 {


    public static void commonSubstring(List<String> a, List<String> b) {

        // a = ["ab", "cd", "ef"]
        // b = ["af", "ee", "ef"]
        boolean found = false;
        for (int i = 0; i < a.size(); i++) {

            found = false;
            String currStr = a.get(i);
            Set<Character> charSet = new HashSet<>();

            for (int k = 0; k < b.get(i).length(); k++) {
                charSet.add(b.get(i).charAt(k));
            }

            for (int j = 0; j < currStr.length(); j++) {

                char currChar = currStr.charAt(j);

                if (charSet.contains(currChar)) {
                    System.out.println("YES");
                    found = true;
                    break;
                }

            }

            if (!found) {
                System.out.println("NO");
            }

            charSet.clear();
        }

    }

}
