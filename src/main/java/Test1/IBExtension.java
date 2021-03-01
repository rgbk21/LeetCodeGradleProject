package Test1;

public abstract class IBExtension implements InterfaceA {

    abstract public void printClassName();

}

abstract class IBExtension2 /* extends InterfaceA */ {

}

abstract class IBExtension3 extends IBExtension {

}

abstract class IBExtension4 /* implements IBExtension */ {

}

class Impl_IBExtension extends IBExtension {

    @Override
    public void printClassName() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Impl_InterfaceA /* extends InterfaceA */ {


}