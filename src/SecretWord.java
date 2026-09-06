import java.util.LinkedHashSet;
import java.util.Set;

public class SecretWord {
    private String randomWord;
    private StringBuilder maskRandomWord;

    private Set<Character> setUsedLetters = new LinkedHashSet<>();

    public SecretWord(String randomWord, StringBuilder maskRandomWord) {
       this.randomWord = randomWord;
       this.maskRandomWord = maskRandomWord;
    }

    public StringBuilder findLetterInWord(char letter) {
            checkLetter(letter);
            return maskRandomWord;
    }

    public boolean isLetterUsed(char letter) {
        if (setUsedLetters.contains(letter)) {
            System.out.println("Вы уже вводили эту букву: " + setUsedLetters);
            System.out.println("Текущее слово: " + maskRandomWord);
            return true;
        }
        addUsedLetterInList(letter);
        return false;
    }

    private void addUsedLetterInList(char letter) {
        setUsedLetters.add(letter);
        System.out.println();
        System.out.println("Использованные буквы: " + setUsedLetters);
    }

    private StringBuilder checkLetter(char letter) {
        if (randomWord.indexOf(String.valueOf(letter)) != -1) {
            return handleCorrectLetter(letter);
        }

        return maskRandomWord;
    }

    private StringBuilder handleCorrectLetter(char letter) {
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == letter) {
                maskRandomWord.setCharAt(i, letter);
            }
        }
        System.out.println("Текущее слово: " + maskRandomWord);
        return maskRandomWord;
    }
}



