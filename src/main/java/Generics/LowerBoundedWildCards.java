package Generics;

public class LowerBoundedWildCards {

    // You had a question about why we are using Wrapper<?> in Upper Bound example
    // but using Wrapper<T> type in lower-bound. Well this is why:
    public static void copy_v0(Wrapper<?> source, Wrapper<?> dest) {
        Object srcObj = source.getRef();
//        dest.setRef(srcObj); // Compile Error: Required type: capture of ? Provided: Object
    }

    // This is the first/wrong trial attempt that you would be trying to do
    // Note two points:
    // 1) The method name contains <T> and it should appear AFTER the static keyword. Before the static keyword is a compile error
    public static <T> void copy_v1(Wrapper<T> source, Wrapper<T> dest) {
        // 2) Note we are not using Object as a reference type but instead using T
        // IF we use Object reference type, we get a Compile Error
//        Object srcObj = source.getRef();
//        dest.setRef(srcObj); // Compile Error: Required type: T Provided: Object
        T srcObj = source.getRef();
        dest.setRef(srcObj);
    }

    public static <T> void copy_v2(Wrapper<T> source, Wrapper<? super T> dest) {
        T value = source.getRef();
        dest.setRef(value);
    }


    public static void main(String[] args) {
        // We call the method as follows:
        // And this leads to a compile error
        Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
        Wrapper<Object> stringWrapper2 = new Wrapper<>("Hello");
        // copy_v1(stringWrapper, objectWrapper); //
        copy_v1(stringWrapper2, objectWrapper); //
        copy_v1(new Wrapper<>("Hello"), new Wrapper<>(new Object()));
        copy_v2(stringWrapper, objectWrapper); // Compiles without any issues.
    }
}
