import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Insert length of password as a number: ");
        Generator test = new Generator(userInput.nextInt());
    }
}
