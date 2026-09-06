import java.util.Scanner;

public class MenuGame {
    private static ConsoleUserInput input = new ConsoleUserInput(new Scanner(System.in));

    public static Game game = new Game(input);

    public static final String START = "да";
    public static final String STOP = "нет";

    static {
        System.out.println("Добро пожаловать !");
        System.out.printf("Хотите начать новую игру? (%s/%s)%n", START, STOP);
    }

    public static void start() {
        while (true) {
            String answerFromUser = input.inputLine().toLowerCase();

            switch (answerFromUser) {
                case START -> {
                    game.playGame();
                    return;
                }
                case STOP -> {
                    game.endGame();
                    return;
                }
                default -> System.out.println(
                        "Нераспознанная команда. Повторите еще раз."
                );
            }
        }
    }
}
