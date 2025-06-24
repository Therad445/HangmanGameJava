package io.github.therad445.hangmangame.hangman.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;

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
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int indexRandomElement = random.nextInt(0, (wordsList.size() - 1));
        this.usingWord = wordsList.get(indexRandomElement);
    }
}
