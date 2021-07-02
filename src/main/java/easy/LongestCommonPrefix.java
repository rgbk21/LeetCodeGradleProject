package easy;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix.longestCommonPrefix(new String[] {"ca", "a"});
        LongestCommonPrefix.longestCommonPrefix_v3(new String[] {"flower","flow","flight"});
    }

    public static String longestCommonPrefix_v3(String[] strs){

        String longestCommonSbstr = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            String leftStr = longestCommonSbstr;
            String rightStr = strs[i+1];
            int idx = 0;
            while (idx < leftStr.length() && idx < rightStr.length() && leftStr.charAt(idx) == rightStr.charAt(idx)) {
                idx++;
            }
            longestCommonSbstr = leftStr.substring(0, idx);
            if (longestCommonSbstr.isEmpty()) return "";
        }

        return longestCommonSbstr;

    }

    //I don't even understand what I was doing over here>????!!!!
    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        StringBuilder lcp = new StringBuilder();
        String minLengthStr = strs[0];
        for (String s : strs) {
            if (s.length() < minLengthStr.length()) {
                minLengthStr = s;
            }
        }

        for(int i = 0; i < minLengthStr.length(); i++){
            char currentChar = minLengthStr.charAt(i);
            for (String str : strs) {
                if (str.length() < i || str.charAt(i) != currentChar) {
                    return lcp.toString();
                }
            }
            lcp.append(currentChar);

        }

        return lcp.toString();
    }

    //Correct solution......
    public static String longestCommonPrefix_2(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < strs.length; i++) {

            String currString = strs[i];
            int idx = 0;
            int len = Math.min(prefix.length(), currString.length());

            while (idx < len && prefix.charAt(idx) == currString.charAt(idx)) {
                sb.append(prefix.charAt(idx));
                idx++;
            }

            prefix = sb.toString();
            sb = new StringBuilder();

        }

        return prefix;

    }

}
