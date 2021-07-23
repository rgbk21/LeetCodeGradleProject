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

        // Do not use the while loop condition as:
        // while (front != back)
        // Because you are simultaneously incremeting and decrementing the pointers.
        // So there is a chance that they never become equal.
        while (front <= back) {
            // Note the initialization of the temp variable here.
            // Initialize char to this value if required.
            char temp = '\u0000';
            temp = s[front];
            s[front] = s[back];
            s[back] = temp;
            front++;
            back--;
        }
    }
}
