package exception;


public class WordsFileNotFoundException extends RuntimeException {

    public WordsFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
