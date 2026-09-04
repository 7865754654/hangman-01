import java.util.Scanner;

public class Game {
    private static Scanner console = new Scanner(System.in);

    private static final String WORDS_FILE  = "words.txt";

    private static Dictionary dictionary = new Dictionary(WORDS_FILE);

    private static int gameAttempt = 5;

    private static final String START = "да";
    private static final String STOP = "нет";

    public static void setGameAttempt(int newGameAttempt) {
        gameAttempt = newGameAttempt;
    }

    static {
        System.out.println("Добро пожаловать !");
        System.out.printf("Хотите начать новую игру? (%s/%s)%n", START, STOP);
    }


    public static void start() {
        while (true) {
            String answerFromUser = console.nextLine().toLowerCase();

            switch (answerFromUser) {
                case START -> {
                    playGame();
                    return;
                }
                case STOP -> {
                    endGame();
                    return;
                }
                default -> System.out.println(
                        "Нераспознанная команда. Повторите еще раз."
                );
                }
            }
        }


    private static void playGame() {
        System.out.println();


        try {
            String randomWord = dictionary.chooseRandomWord();
            System.out.println("У вас есть 5 попыток, чтобы угадать слово.");

            StringBuilder maskRandomWord = new Mask(randomWord).hideWord();

            SecretWord secretWord = new SecretWord(randomWord, maskRandomWord);

            while (gameAttempt > 0 && !randomWord.equals(maskRandomWord.toString())) {
                char letter = guessLetter();
                secretWord.setLetter(letter);

                maskRandomWord = secretWord.findLetterInWord(gameAttempt);
            }

            if (playAgain()) {
                playGame();
            } else {
                endGame();
            }

        } catch (RuntimeException e) {
            System.out.println("Не удалось запустить игру. Попробуйте позже.");
            e.printStackTrace();
        }
    }


    private static char guessLetter() {
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


    public static boolean playAgain() {
        if (gameAttempt == 0) {
            gameAttempt = 5;
            System.out.printf("Вы проиграли. Хотите начать заново ?%n");
        } else {
            System.out.printf("Вы справились ! Хотите начать заново ?%n");
        }
        return console.nextLine().equalsIgnoreCase(START);
    }


    private static void endGame() {
        System.out.println();
        System.out.println("Завершение сессии.");
    }
}





