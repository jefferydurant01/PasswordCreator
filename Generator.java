import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Generator {
    private final ArrayList<String> chain = new ArrayList<>();
    private int symbolCount, numberCount, upperCaseCount, lowerCaseCount;
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
            print();

        } catch (PasswordLength e) {
            System.out.println(e);
        }
    }

    public String generate(int length) throws PasswordLength {
        if (!checkLength(length)) {
            throw new PasswordLength("Password length too short. The recommended length is 8 characters");
        }

        for (int i = 0; i < length; i++){
            Random r = new Random();
            int key = r.nextInt(5);
            int index;
            switch (key) {
                case 0, 1 -> {
                    index = r.nextInt(numbers.length);
                    chain.add(Integer.toString(numbers[index]));
                    numberCount++;
                }
                case 2 -> {
                    index = r.nextInt(symbols.length);
                    chain.add(Character.toString(symbols[index]));
                    symbolCount++;
                }
                case 3 -> {
                    index = r.nextInt(upperCase.length);
                    chain.add(upperCase[index]);
                    upperCaseCount++;
                }
                case 4 -> {
                    index = r.nextInt(lowerCase.length);
                    chain.add(lowerCase[index]);
                    lowerCaseCount++;
                }
                default -> {
                }
            }
        }
        return chain.toString();
    }

    public boolean checkLength(int length) {
        return (length >= 8);
    }

    public void print(){
        StringBuilder password = new StringBuilder();
        for (String s : chain) {
            password.append(s);
        }
        System.out.println("Password:" + password);
        System.out.println("Password length is " + chain.size());
        System.out.println(numberCount + " numbers, " + symbolCount + " symbols, " + upperCaseCount + " upper-case letters, " + lowerCaseCount + " lower-case letters.");

        Scanner userAnswer = new Scanner(System.in);
        System.out.println("Would you like to save the password? (Y/N)");
        String answer = userAnswer.next();

        if (answer.equalsIgnoreCase("y")){
            ListOfPasswords list = new ListOfPasswords();
            list.saveToFile(password.toString());
        }


    }
}
