package Generics;

//public class SOQuestion {
//
//    public static <T> void copy_v1(Wrapper<T> source, Wrapper<T> dest) {
//        T srcObj = source.getRef();
//        dest.setRef(srcObj);
//    }
//
//    public static void main(String[] args) {
//        Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
//        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
//        copy_v1(stringWrapper, objectWrapper); // Does not compile.
//        copy_v1(new Wrapper<String>("Hello"), new Wrapper<Object>(new Object())); // But this compiles
//    }
//
//}
//
//class Wrapper<T> {
//
//    private T ref;
//
//    Wrapper(T ref) {
//        this.ref = ref;
//    }
//
//    public T getRef() {
//        return this.ref;
//    }
//
//    public void setRef(T ref) {
//        this.ref = ref;
//    }
//}