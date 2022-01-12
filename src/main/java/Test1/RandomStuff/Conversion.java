package Test1.RandomStuff;

public class Conversion {

  public static void main(String[] args) {

    char myChar1 = '3';//ASCII value = 51
    char myChar3 = 'A';//ASCII value = 65

    // char to literal int
    int myInt1 = Character.getNumericValue(myChar1);
    System.out.println("myInt1: " + myInt1);                //Prints: myInt1 = 3

    // char to literal int
    int myInt7 = myChar1; //no need to cast char to int!
    System.out.println("myInt7: " + myInt7);                //Prints: myInt7: 51

    // int to char (note that only a single digit will be converted to char)
    char myChar2 = Character.forDigit(myInt1, 10);      //myChar2 = '3'
    System.out.println("myChar2: " + myChar2);              //Prints: myChar2: 3
    System.out.println("myChar2: " + (int) myChar2);        //Prints: myChar2: 51

    //Convert char to String
    //myChar3 = 'A'
    String myStr5 = Character.toString(myChar3);
    System.out.println("myStr5: " + myStr5);                //Prints: myStr5: "A"

    myStr5 = String.valueOf(myChar3);
    System.out.println("myStr5: " + myStr5);                //Prints: myStr5: "A"


    //char can be appended to String without any conversion
    String s = "myStr";
    s += myChar2;
    System.out.println("s: " + s);                          //Prints: s: myStr3

    //https://stackoverflow.com/a/15633542/8742428
    //Character.toString() internally calls String.valueOf()
    //Prefer String.valueOf() to convert char to String

    //myChar2 = '3'
    String myStr4 = String.valueOf(myChar2);
    System.out.println("myStr4: " + myStr4);                //Prints: myStr4: "3"

    myStr4 = Character.toString(myChar2);
    System.out.println("myStr4: " + myStr4);                //Prints: myStr4: "3"


    // Conversion from and to String

    String myStr1 = "1234";
    String myStr6 = "A";

    //string to int value
    int myInt8 = Integer.parseInt("1234");
    int myInt2 = Integer.valueOf(myStr1);
    System.out.println("myInt2: " + myInt2);                //Prints: myInt2: 1234

    //int to String
    String myStr3 = String.valueOf(myInt2);
    System.out.println("myStr3: " + myStr3);                //Prints: myStr3: "1234"

    //Convert string to char
    char myChar6 = myStr6.charAt(0);
    System.out.println("myChar6: " + myChar6);

  }

}
