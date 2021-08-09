package Collections.HashBasedCollections;

import java.util.Objects;

// When
public class ProblemKey {

    private String name;

    public ProblemKey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProblemKey setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemKey that = (ProblemKey) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class ProblemKey2 {

    private String name;

    public ProblemKey2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProblemKey2 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemKey2 that = (ProblemKey2) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
