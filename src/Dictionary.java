import exception.FileReadException;
import exception.WordsFileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;


public class Dictionary {
    private String fileName;

    public Dictionary(String fileName) {
        this.fileName = fileName;
    }


    public String chooseRandomWord() {

        List<String> words = getWordsFromFile();

        Random random = new Random();
        int randomIndexWord = random.nextInt(words.size());

        return (words.get(randomIndexWord));
    }


    private List<String> getWordsFromFile() {
        try {
            Path path = Path.of("resources", fileName);
            return Files.readAllLines(path);

        } catch (NoSuchFileException e) {
            throw new WordsFileNotFoundException("Файл не найден " + fileName, e);
        } catch (IOException e) {
            throw new FileReadException("Ошибка чтения файла " + fileName, e);
        }
    }
}



