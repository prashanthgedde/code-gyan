package prashanthgedde.codegyan.backtracking;

import java.util.List;
import java.util.ArrayList;

public class n01_RollDice {

    public static void rollDice(int numDice) {
        String soFar = "";

        // METHOD1
        //rollDice_(numDice, soFar);

        // METHOD2
        rollDice_(numDice, new ArrayList<Integer>());
    }

    // METHOD-1: Builds a string on the fly.
    //  Each recursive call creates a fresh string.
    //  Hence, no need for backtracking.
    private static void rollDice_(int numDice, String soFar) {
        if(numDice == 0) {
            System.out.println(soFar);
            return;
        }

        for(int i=1; i<=6; i++) {
            rollDice_(numDice-1, soFar+i+",");
        }
    }

    // METHOD-2: Uses a list shared across recursive calls.
    //  Before exploring other paths we need to clear off the last choice.
    //  That's nothing but backtracking.
    //  For ex: In 2 dice case, after fixing first dice at 1, we need to explore 2nd dice starting at 1,
    //    then remove that 1, and explore 2 and so on.. which requires us to clearing off
    //    last tried choice which is nothing but backtracking!!!
    private static void rollDice_(int numDice, List<Integer> list) {
        if(numDice == 0) {
            for(int v: list) {
                System.out.print(v+", ");
            }
            System.out.println("");
            return;
        }
        for(int i=1; i<=6; i++) {
            list.add(i);
            rollDice_(numDice-1, list);
            list.remove(list.size()-1);   // <<<<<----- Backtracking to explore other possibilities
        }
    }

    public static void main(String []args) {
        rollDice(1);
    }
}
