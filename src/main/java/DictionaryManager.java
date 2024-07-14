import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryManager {

    String getRandomWord(WordLength wordLength) {
        int length;
        switch (wordLength) {
            case SMALL -> length = 6;
            case MIDDLE -> length = 7;
            case LARGE -> length = 8;
            default -> length = 0;
        }
        return findWordInDictionary(length);
    }

    private String findWordInDictionary(int length) {
        if (length < 6 || length > 8) return "";
        String fileName = "src/main/java/service/dictionary_" + length + ".txt";
        List<String> wordList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) {
                wordList.add(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Random random = new Random();
        int index = random.nextInt(wordList.size());
        return wordList.get(index - 1);
    }
}
