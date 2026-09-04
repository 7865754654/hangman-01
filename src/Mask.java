public class Mask {
    private String randomWord;

    public Mask(String randomWord) {
        this.randomWord = randomWord;
}

    public StringBuilder hideWord() {
        StringBuilder maskWord = new StringBuilder(randomWord.replaceAll("[a-яA-ЯёЁ]", "_"));

        System.out.println("Слово из " + randomWord.length() + " букв загадано. " + maskWord);
        return maskWord;
    }

}
