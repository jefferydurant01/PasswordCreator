import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    private final ArrayList<String> chain = new ArrayList<>();
    private Random r;
    private final char[] symbols = {'~', '`', '!', '@', '#', '$', '%',
            '^', '&', '*', '(', ')', '_', '-', '+', '=', '{', '[',
            '}', ']', '|', ';', ':', '"', '<', '>', ',', '.', '?', '/'};
    private final int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private final String[] upperCase = {"A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private final String[] lowerCase = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q",
            "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    Generator(int length) {
        try {
            generate(length);
        } catch (PasswordLength e) {
            System.out.println(e);
        }
    }

    public String generate(int length) throws PasswordLength {
        if (!checkLength(length)) {
            throw new PasswordLength("Password length too short. Recommended length is 8 characters");
        }
        Scanner userInput = new Scanner(System.in);
        //add choices
        return chain.toString();
    }

    public boolean checkLength(int length) {
        return (length >= 8);
    }
}
