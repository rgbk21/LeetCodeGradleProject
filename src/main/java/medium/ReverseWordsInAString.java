package medium;

public class ReverseWordsInAString {

    public static void main(String[] args) {

    }

    public String reverseWords(String s) {

        //  the sky is blue
        String singleSpacedStr = s.replaceAll("\\s+", " ");
        // [the, sky, is, blue]
        String[] splitSSStr = singleSpacedStr.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = splitSSStr.length - 1; i >= 0; i--) {
            sb.append(splitSSStr[i]).append(" ");
        }

        return sb.toString().trim();

    }

}
