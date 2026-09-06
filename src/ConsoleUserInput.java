import java.util.Scanner;

public class ConsoleUserInput {
    public Scanner console;

    public ConsoleUserInput(Scanner console) {
        this.console = console;
    }

    public String inputLine() {
        return console.nextLine();
    }

    public char inputLetter() {
        while (true) {
            System.out.println();
            System.out.print("Введите русскую букву: ");
            String input = console.nextLine().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            char letter = input.charAt(0);

            if ((letter >= 'а' && letter <= 'я') || letter == 'ё') {
                return letter;
            }
        }
    }
}
