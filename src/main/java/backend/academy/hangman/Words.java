package backend.academy.hangman;

import lombok.Getter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Words {
    private static final Map<String, List<String>> HANGMAN_WORDS = createHangmanWords();
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
        }
        ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
        int indexRandomElement = RANDOM.nextInt(0, (wordsList.size() - 1));
        this.usingWord = wordsList.get(indexRandomElement);
    }

    public static Map<String, List<String>> getHangmanWords() {
        return HANGMAN_WORDS;
    }

    private static void addCategory(Map<String, List<String>> map, String category, String... words) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Нужно указать категории");
        } else if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Нужно указать слова");
        }
        map.put(category, Arrays.asList(words));
    }

    private static Map<String, List<String>> createHangmanWords() {
        Map<String, List<String>> words = new HashMap<>();
        addCategory(words, "животные", "носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка");
        addCategory(words, "фрукты", "яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец");
        addCategory(words, "ягоды", "клубника", "ежевика", "голубика", "брусника", "земляника");
        addCategory(words, "молочные продукты", "сыр", "йогурт", "молоко", "масло", "кефир");
        return Collections.unmodifiableMap(words);
    }
}
