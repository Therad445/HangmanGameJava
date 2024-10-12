package backend.academy.hangman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HangmanGame {
    @Getter
    private static final Map<String, List<String>> HANGMAN_WORDS = new HashMap<>();

    private final String category;
    private final String word;
    private final StringBuilder usedWord;
    private final Set<Character> usedCharacters;
    private int attempts;

    static {
        HANGMAN_WORDS.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"));
        HANGMAN_WORDS.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огуруец"));
        HANGMAN_WORDS.put("ягоды", Arrays.asList("клубника", "ежевика", "голубика", "брусника", "земляника"));
        HANGMAN_WORDS.put("молочные продукты", Arrays.asList("сыр", "йогурт", " молоко", "масло", "кефир"));
    }

    public HangmanGame(String category, String word, int attempts) {
        this.category = category;
        this.word = word;
        this.attempts = attempts;
        this.usedWord = new StringBuilder("_".repeat(word.length()));
        this.usedCharacters = new HashSet<>();
    }

    public void displayInfo() {
        log.info("Категория: {}", category);
        log.info("Осталось попыток: {}", attempts);
        log.info("Слово: {}", usedWord);
        log.info("Висилица:\n{}", HangmanPaint.hangmanPaint(attempts));
    }

    public boolean inputChar(char symbol) {
        char lowerSymbol = Character.toLowerCase(symbol);
        if (usedCharacters.contains(lowerSymbol)) {
            log.info("Вы уже вводили этот символ");
            return false;
        }
        usedCharacters.add(lowerSymbol);
        if (word.contains(Character.toString(lowerSymbol))) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == lowerSymbol) {
                    usedWord.setCharAt(i, lowerSymbol);
                }
            }
            return true;
        } else {
            attempts--;
            return false;
        }
    }

    public boolean gameOver() {
        if (attempts == 0) {
            log.info("Поражение. Было загадано: {}", word);
            return true;
        } else if (usedWord.toString().equals(word)) {
            log.info("Победа! Было загадано: {}", word);
            return true;
        }
        return false;
    }
}
