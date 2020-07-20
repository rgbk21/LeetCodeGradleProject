package easy;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String s = "Hello World Awesome";
        LengthOfLastWord.lengthOfLastWord(s);

    }

    public static int lengthOfLastWord(String s) {

        if (s == null) return 0;
        s = s.trim();
        String[] splitStr = s.split(" ");

        for(int i = splitStr.length - 1; i >= 0; i--){
            String word = splitStr[i];
            if(word.length() > 0){
                return word.length();
            }
        }

        return 0;
    }

}
