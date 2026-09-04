import java.util.LinkedHashSet;
import java.util.Set;

public class SecretWord {
    private String randomWord;
    private StringBuilder maskRandomWord;

    private Set<Character> setUsedLetters = new LinkedHashSet<>();

    private char letter;

    public void setLetter(char letter) {
        this.letter = letter;
    }


    public SecretWord(String randomWord, StringBuilder maskRandomWord) {
       this.randomWord = randomWord;
       this.maskRandomWord = maskRandomWord;
    }

    public StringBuilder findLetterInWord(int gameAttempt) {
        if (!isLetterUsed()) {
            checkLetter(gameAttempt);
        }

        return maskRandomWord;
    }

    private boolean isLetterUsed() {
        if (setUsedLetters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву: " + setUsedLetters);
            System.out.println("Текущее слово: " + maskRandomWord);
            return true;
        }
        addUsedLetterInList();
        return false;
    }


    private void addUsedLetterInList() {
        setUsedLetters.add(letter);
        System.out.println();
        System.out.println("Использованные буквы: " + setUsedLetters);
    }


    private StringBuilder checkLetter(int gameAttempt) {
        if (randomWord.indexOf(String.valueOf(letter)) != -1) {
            return handleCorrectLetter();
        }
            return handleWrongLetter(gameAttempt);
    }


    private StringBuilder handleCorrectLetter() {
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) {
                maskRandomWord.setCharAt(i, letter);
            }
        }
        System.out.println("Текущее слово: " + maskRandomWord);
        return maskRandomWord;
    }


    private StringBuilder handleWrongLetter(int gameAttempt) {
        gameAttempt = decrementGameAttempts(gameAttempt);
        drawHangman(gameAttempt);

        if (gameAttempt == 0) {
            System.out.println(letter + " Такой буквы нет. Осталась " + gameAttempt + " попыток.");
            System.out.println("Правильное слово: " + randomWord);
        }
        else if (gameAttempt == 1) {
            System.out.println(letter + " Такой буквы нет. Осталась " + gameAttempt + " попытка.");
        }
        else {
            System.out.println(letter + " Такой буквы нет. Осталось " + gameAttempt + " попытки.");
        }
        System.out.println("Текущее слово: " + maskRandomWord);

        return maskRandomWord;
    }

    private int decrementGameAttempts(int gameAttempt) {
        --gameAttempt;

        Game.setGameAttempt(gameAttempt);

        return gameAttempt;
    }

    private void drawHangman(int gameAttempt) {
        String picturePartOfHangman = Hangman.PART_HANGMAN[gameAttempt];
        System.out.println(picturePartOfHangman);
    }
}



