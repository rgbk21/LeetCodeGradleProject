package Interfaces.SharedConstants;

import java.util.Random;

public interface SharedConstants {
    int NO = 0;
    int YES = 1;
    int MAYBE = 2;
}

class Question implements SharedConstants {

    Random rand = new Random();

    public int ask() {
        int prob = (int) (100 * rand.nextFloat());
        if (prob < 30) {
            return NO;
        } else if (prob < 70) {
            return MAYBE;
        } else {
            return YES;
        }
    }
}

class AskMe implements SharedConstants {

    public static void answer(int result) {

        switch (result) {
            case NO:
                System.out.println("No");
                break;

            case YES:
                System.out.println("Yes");
                break;

            case MAYBE:
                System.out.println("Maybe");
                break;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Question q = new Question();
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
        AskMe.answer(q.ask());
    }
}