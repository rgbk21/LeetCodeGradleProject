package JoshuaBloch.Chapter3.Item10.Symmetry;

import java.util.Objects;

public class CaseInsensitiveString {

    private final String str;

    public CaseInsensitiveString(String s) {
        this.str = Objects.requireNonNull(s);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof CaseInsensitiveString) {
//            CaseInsensitiveString caseInsensitiveString = (CaseInsensitiveString) obj;
//            return caseInsensitiveString.str.equalsIgnoreCase(this.str);
//        }
//
//        // One-way interoperability!
//        if (obj instanceof String) {
//            String string = (String) obj;
//            return string.equalsIgnoreCase(this.str);
//        }
//
//        return false;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        CaseInsensitiveString caseInsensitiveString = (CaseInsensitiveString) obj;
        return this.str.equalsIgnoreCase(caseInsensitiveString.str);
    }


    // This is the equals that was written using the default implementation generate by intellij as a template
    // Note that this will return false if you end up comparing CaseInsensitiveString with String
    // because of this: if (obj == null || this.getClass() != obj.getClass()) return false;
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || this.getClass() != obj.getClass()) return false;
//        CaseInsensitiveString caseInsensitiveString = (CaseInsensitiveString) obj;
//        return this.str.equalsIgnoreCase(caseInsensitiveString.str);
//    }


    // This is the equals that was auto-generated by IntelliJ
    // Note that the overridden equals methods is checking whether the two strings being compared
    // are EXACTLY equal or not. And not checking for equalsIgnoreCase, as we want
    // So do not blindly use the equals method. Check what is going on.
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        CaseInsensitiveString that = (CaseInsensitiveString) o;
//
//        return str.equals(that.str);
//    }

    @Override
    public int hashCode() {
        return str.hashCode();
    }
}

class TestClass {

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        System.out.println("cis.equals(s): " + cis.equals(s)); // false
        System.out.println("s.equals(cis): " + s.equals(cis)); // false

//        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
//        String s = "polish";
//
//        List<CaseInsensitiveString> list = new ArrayList<>();
//        list.add(cis);
//
//        System.out.println(list.contains(s));
    }

}