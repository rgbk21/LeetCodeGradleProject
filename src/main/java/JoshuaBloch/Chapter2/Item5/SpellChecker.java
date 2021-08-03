package JoshuaBloch.Chapter2.Item5;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SpellChecker {

    private final UserDictionary dictionary;

    // No longer a private constructor
    SpellChecker(UserDictionary dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    // Methods to perform actions using this SpellChecker
    // Methods no loger static
    public boolean isValidWord(String word) {
        return true;
    }

    public List<String> suggestions(String word) {
        return new ArrayList<>();
    }
}
