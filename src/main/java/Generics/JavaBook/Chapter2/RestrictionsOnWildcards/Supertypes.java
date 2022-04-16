package Generics.JavaBook.Chapter2.RestrictionsOnWildcards;

import java.util.ArrayList;
import java.util.List;

public class Supertypes {}

// Compile Error
//class SomeList1 extends ArrayList<?> {} // No wildcard expected

// Compile Error
//class SomeList2 implements List<?> {} // No clue.

// Nested are ok
class SomeList3 extends ArrayList<List<?>> {} // All ok here.
