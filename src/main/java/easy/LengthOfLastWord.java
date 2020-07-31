package easy;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String s = "Hello World Awesome";
        LengthOfLastWord.lengthOfLastWord(s);

    }

    //BAAAAAAAAD
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

    //OOOOOOOOK
    public static int lengthOfLastWord_2(String s) {

        int idx = s.length() - 1;
        int len = 0;

        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        if (idx == 0 && s.charAt(idx) == ' ') {
            return 0;
        }

        while (idx >= 0 && s.charAt(idx) != ' ') {
            len++;
            idx--;
        }

        return len;

    }

}
