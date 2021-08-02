package JoshuaBloch.Chapter2.Item1;

public class StaticTest {

    public static void main(String[] args) {

        CreatorClass class1 = new CreatorClass();
        CreatorClass class2 = new CreatorClass();

        BaseClass baseClassOfClass1 = class1.getBaseClassInstance();
        BaseClass baseClassOfClass2 = class2.getBaseClassInstance();

        // Now as per our understanding,
        // the two instances of baseClassOfClass1 and baseClassOfClass2 must be the same
        System.out.println("Are two instances same: " + (baseClassOfClass1 == baseClassOfClass2)); // true
    }
}

class CreatorClass {

    private static final BaseClass baseClass = new BaseClass();

    public BaseClass getBaseClassInstance() {
        return baseClass;
    }
}

class BaseClass {

    private String name = "BaseClass";

    public String getName() {
        return name;
    }

    public BaseClass setName(String name) {
        this.name = name;
        return this;
    }
}