package JoshuaBloch.Chapter2.Item5;

import java.util.ArrayList;
import java.util.List;

// We wil have to create a new SpellChecker for every language that we intend to use
// The behovior of the SpellChecker is tied to the type of Dictionary that it uses
public class EnglishSpellChecker {

    private static final UserDictionary dictionary = new EnglishDictionary();

    // No instantiation possible
    private EnglishSpellChecker() {
    }

    // Static Utility methods to perform actions using this SpellChecker
    public static boolean isValidWord(String word) {
        return true;
    }

    public static List<String> suggestions(String word) {
        return new ArrayList<>();
    }
}

interface UserDictionary {
}

class EnglishDictionary implements UserDictionary {
}
