package easy;


//https://leetcode.com/problems/reverse-string/

public class ReverseString {

    public static void main(String[] args) {
        char[] str = new char[] {'h','e','l','l','o'};
        reverseString(str);
    }

    public static void reverseString(char[] s) {

        int front = 0;
        int back = s.length - 1;

        while (front <= back) {
            char temp = '\u0000';
            temp = s[front];
            s[front] = s[back];
            s[back] = temp;
            front++;
            back--;
        }
    }

}
