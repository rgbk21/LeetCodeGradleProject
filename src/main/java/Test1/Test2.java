package Test1;

public class Test2 {

    public static void main(String[] args) throws Exception {

        System.out.println(isAlphanumeric(""));

        Person p1 = new Student();
        p1.getName();


    }

    public static boolean isAlphanumeric(String s) {

        if (s.length() == 0) return false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c < 49 || (c >= 58 && c < 65) || (c > 90 && c < 97 ) || c > 122) {
                return false;
            }

        }

        return true;

    }
}


class Person {

    String name;

    public String getName() throws Exception {
        System.out.println("Person" + this.name);
        return this.name;
    }

}

class Student extends Person {

    @Override
    public String getName() throws Exception {
        System.out.println("Student: " + this.name);
        return this.name;
    }

}