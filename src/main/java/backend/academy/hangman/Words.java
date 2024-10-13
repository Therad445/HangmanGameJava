package backend.academy.hangman;

import lombok.Getter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Words {
    private final List<String> wordsList;
    @Getter
    private String usingWord;
    public Words(List<String> wordsList) {
        if (wordsList == null || wordsList.isEmpty()) {
            throw new IllegalArgumentException("Нужно указать слова");
        }
        this.wordsList = Collections.unmodifiableList(wordsList);
        randomWord();
    }

    private void randomWord() {
        if (usingWord != null) {
            throw new IllegalArgumentException("Загаданное слово уже выбрано");
        } else if (wordsList.size() < 2) {
            throw new IllegalArgumentException("Слишком мало слов, чтобы выбор был случайным");
        }
        ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
        int indexRandomElement = RANDOM.nextInt(0, (wordsList.size() - 1));
        this.usingWord = wordsList.get(indexRandomElement);
    }
}
