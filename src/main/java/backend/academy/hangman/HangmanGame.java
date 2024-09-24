package backend.academy.hangman;

import lombok.Getter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HangmanGame {
    @Getter private static final Map<String, List<String>> hangmanWords = new HashMap<>();

    private final String category;
    private final String word;
    private final String difficulty;
    private StringBuilder usedWord;
    private Set<Character> usedCharacters;
    private int attempts;

    static {
        hangmanWords.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру"));
        hangmanWords.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин"));
        hangmanWords.put("ягоды", Arrays.asList("клубника", "еживика", "голубика", "брусника"));
    }

    public HangmanGame(String category, String word, int attempts, String difficulty) {
        this.category = category;
        this.word = word;
        this.attempts = attempts;
        this.difficulty = difficulty;
        this.usedWord = new StringBuilder("_".repeat(word.length()));
        this.usedCharacters = new HashSet<>();
    }

    public void displayInfo() {
        System.out.println("Категория: " + category);
        System.out.println("Сложность: " + difficulty);
        System.out.println("Осталось попыток: " + attempts);
        System.out.println("Слово: " + usedWord);
        System.out.println("Висилица:\n" + HangmanPaint.hangmanPaint(attempts));
    }

    public boolean inputChar(char symbol) {
        char lowerSymbol = Character.toLowerCase(symbol);
        if (usedCharacters.contains(lowerSymbol)) {
            System.out.println("Вы уже вводили этот символ");
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
            System.out.println("Поражение. Было загадано: " + word);
            return true;
        } else if (usedWord.toString().equals(word)) {
            System.out.println("Победа! Было загадано: " + word);
            return true;
        }
        return false;
    }
}
