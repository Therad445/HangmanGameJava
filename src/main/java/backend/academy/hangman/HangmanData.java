package backend.academy.hangman;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HangmanData {

    private static final Map<String, List<String>> HANGMAN_DATA = createHangmanData();

    public static Map<String, List<String>> getHangmanData() {
        return HANGMAN_DATA;
    }

    private static Map<String, List<String>> createHangmanData() {
        Map<String, List<String>> words = new HashMap<>();
        addCategory(words, "животные", "носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка");
        addCategory(words, "фрукты", "яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец");
        addCategory(words, "ягоды", "клубника", "ежевика", "голубика", "брусника", "земляника");
        addCategory(words, "молочные продукты", "сыр", "йогурт", "молоко", "масло", "кефир");
        return Collections.unmodifiableMap(words);
    }
    private static void addCategory(Map<String, List<String>> map, String category, String... words) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Нужно указать категории");
        } else if (words == null || words.length == 0) {
            throw new IllegalArgumentException("Нужно указать слова");
        }
        map.put(category, Arrays.asList(words));
    }
}
