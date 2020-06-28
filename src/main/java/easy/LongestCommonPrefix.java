package easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix.longestCommonPrefix(new String[] {"ca", "a"});
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        StringBuilder lcp = new StringBuilder();
        String minLengthStr = strs[0];
        for (int i = 0; i < strs.length; i++){
            if(strs[i].length() < minLengthStr.length()){
                minLengthStr = strs[i];
            }
        }

        for(int i = 0; i < minLengthStr.length(); i++){
            char currentChar = minLengthStr.charAt(i);
            for(int j = 0; j < strs.length; j++){
                String str = strs[j];
                if(str.length() < i || str.charAt(i) != currentChar){
                    return lcp.toString();
                }
            }
            lcp.append(currentChar);

        }

        return lcp.toString();
    }

}
