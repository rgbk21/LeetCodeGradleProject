package JoshuaBloch.Chapter2.Item3.enumType;

public enum Alice {

    INSTANCE;

    private String name = "Alice";
    public Integer age = 32;

    public void doSomething() {
        System.out.println("Inside doSomething()");
    }

}
