package prashanthgedde.codegyan.backtracking;

/**
 * Generate all permutations of a string.
 *
 */
public class n04_StringPermute {

    public static void permute(String input, String sofar) {
        if(input.length() == 0) {
            System.out.println(sofar);
            return;
        }

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            permute(input.substring(0, i)+input.substring(i+1), sofar+c);
        }
    }

    public static void main(String[] args) {
        permute("abc", "");
    }
}
