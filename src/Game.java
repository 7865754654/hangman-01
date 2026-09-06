public class Game {
    private static final String WORDS_FILE  = "words.txt";

    private static int gameAttempt = 5;

    private Dictionary dictionary = new Dictionary(WORDS_FILE);

    private String randomWord;
    private StringBuilder maskRandomWord;

    private char letter;

    private ConsoleUserInput input;

    public Game(ConsoleUserInput input) {
        this.input = input;
    }

    public void playGame() {
        System.out.println();

        try {
            System.out.println("У вас есть 5 попыток, чтобы угадать слово.");
            randomWord = dictionary.chooseRandomWord();
            maskRandomWord = new Mask(randomWord).hideWord();

            guessSecretWord(randomWord, maskRandomWord);

            if (playAgain()) {
                playGame();
            } else {
                endGame();
            }

        } catch (RuntimeException e) {
            System.out.println("Не удалось запустить игру. Попробуйте позже.");
        }
    }


    private void guessSecretWord(String randomWord, StringBuilder maskRandomWord) {
        SecretWord secretWord = new SecretWord(randomWord, maskRandomWord);

        while (gameAttempt > 0 && !randomWord.equals(maskRandomWord.toString())) {
            letter = input.inputLetter();

            if (secretWord.isLetterUsed(letter)) {
                continue;
            }

            StringBuilder oldMaskRandomWord = new StringBuilder(maskRandomWord);
            StringBuilder updateMaskRandomWord = secretWord.findLetterInWord(letter);

            updateMaskWord(oldMaskRandomWord, updateMaskRandomWord);

        }
    }

    private void updateMaskWord(StringBuilder oldMaskRandomWord,
                                StringBuilder updateMaskRandomWord ) {

        if (oldMaskRandomWord.toString().equals(updateMaskRandomWord.toString())) {
            handleWrongLetter();
        }
        maskRandomWord = updateMaskRandomWord;
    }

    private void handleWrongLetter() {
        --gameAttempt;
        Hangman.drawHangman(gameAttempt);
        printWrongLetterMessage();
    };


    public void printWrongLetterMessage() {
        if (gameAttempt == 0) {
            System.out.println("Такой буквы нет. Осталась " + gameAttempt + " попыток.");
            System.out.println("Правильное слово: " + randomWord);
        }
        else if (gameAttempt == 1) {
            System.out.println("Такой буквы нет. Осталась " + gameAttempt + " попытка.");
        }
        else {
            System.out.println("Такой буквы нет. Осталось " + gameAttempt + " попытки.");
        }
        System.out.println("Текущее слово: " + maskRandomWord);
    }

    private boolean playAgain() {
        if (gameAttempt == 0) {
            gameAttempt = 5;
            System.out.printf("Вы проиграли. Хотите начать заново ?%n");
        } else {
            System.out.printf("Вы справились ! Хотите начать заново ?%n");
        }
        return input.inputLine().equalsIgnoreCase(MenuGame.START);
    }


    public void endGame() {
        System.out.println();
        System.out.println("Завершение сессии.");
    }
}





