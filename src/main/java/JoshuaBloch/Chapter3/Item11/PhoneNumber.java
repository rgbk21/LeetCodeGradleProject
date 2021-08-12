package JoshuaBloch.Chapter3.Item11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber other = (PhoneNumber) o;
        return other.lineNum == lineNum && other.prefix == prefix && other.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = areaCode;
        result = 31 * result + (int) prefix;
        result = 31 * result + (int) lineNum;
        return result;
    }
}

class TestClass {

    public static void main(String[] args) {
        Map<PhoneNumber, String> phoneNumbers = new HashMap<>();

        // Add a phone number to the map
        PhoneNumber key = new PhoneNumber(707, 876, 9990);
        phoneNumbers.put(key, "Alice");

        String nameWhenSearchWithNewObj = phoneNumbers.get(new PhoneNumber(707,876,9990));
        String nameWhenSearchWithKey = phoneNumbers.get(key);
        // Now both of these methods correctly return 'Alice'
        System.out.println("Found Name: " + nameWhenSearchWithNewObj); // Alice
        System.out.println("Found Name: " + nameWhenSearchWithKey); // Alice
    }
}
