public class Mask {
    private String randomWord;

    public Mask(String randomWord) {
        this.randomWord = randomWord;
}

    public StringBuilder hideWord() {
        StringBuilder maskWord = new StringBuilder(randomWord.replaceAll("[a-яA-ЯёЁ]", "_"));

        System.out.printf("Слово из %d букв загадано. %s%n", randomWord.length(), maskWord);
        return maskWord;
    }
}
