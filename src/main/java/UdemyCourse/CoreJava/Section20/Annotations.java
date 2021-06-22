package UdemyCourse.CoreJava.Section20;

@MyAnnotation(name = "Alice", age = "25")
public class Annotations {

        @MyAnnotation(name = "Alice", age = "25", rollNumber = "421")
        private String name;

        @MyAnnotation(name = "Alice", age = "25")
        public static void main(@MyAnnotation(name = "Alice", age = "25") String[] args) {
                @MyAnnotation(name = "Alice", age = "25")
                int age = 10;
        }
}

@interface MyAnnotation {
        String name();
        String age();
        String rollNumber() default "21";
}