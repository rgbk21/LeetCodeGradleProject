package JoshuaBloch.Chapter3.Item10.Baeldung;

class Voucher {

    private Money value;
    private String store;

    Voucher(int amount, String currencyCode, String store) {
        this.value = new Money(amount, currencyCode);
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Voucher))
            return false;
        Voucher other = (Voucher) o;
        boolean valueEquals = (this.value == null && other.value == null)
                || (this.value != null && this.value.equals(other.value));
        boolean storeEquals = (this.store == null && other.store == null)
                || (this.store != null && this.store.equals(other.store));
        return valueEquals && storeEquals;
    }

    // other methods
}

class TestClass {

    public static void main(String[] args) {
        Money cash = new Money(42, "USD");
        Voucher voucher = new Voucher(42, "USD", "Amazon");

        System.out.println("voucher.equals(cash): " + voucher.equals(cash)); // false. As expected.
        System.out.println("cash.equals(voucher): " + cash.equals(voucher)); // false. As expected.
    }

}
