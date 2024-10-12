package backend.academy.hangman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Words {
    @Getter
    private static final Map<String, List<String>> HANGMAN_WORDS = createHangmanWords();
    private List<String> wordsArray;
    private String usingWord;

    public Words(List<String> wordsArray) {
        this.wordsArray = wordsArray;
    }

    public String randomWord() {
        int indexRandomElement = (int) (Math.random() * wordsArray.size());
        return wordsArray.get(indexRandomElement);
    }

    private static void addCategory(Map<String, List<String>> map, String category, String... words) {
        map.put(category, Arrays.asList(words));
    }

    private static Map<String, List<String>> createHangmanWords() {
        Map<String, List<String>> words = new HashMap<>();
        addCategory(words, "животные", "носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка");
        addCategory(words, "фрукты", "яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец");
        addCategory(words, "ягоды", "клубника", "ежевика", "голубика", "брусника", "земляника");
        addCategory(words, "молочные продукты", "сыр", "йогурт", "молоко", "масло", "кефир");
        return words;
    }
}
