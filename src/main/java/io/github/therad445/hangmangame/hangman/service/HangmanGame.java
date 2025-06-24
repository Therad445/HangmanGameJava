package io.github.therad445.hangmangame.hangman.service;

import java.util.HashSet;
import java.util.Set;

import io.github.therad445.hangmangame.hangman.ui.HangmanPaint;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HangmanGame {

    private final String category;
    private final String word;
    private final StringBuilder usedWord;
    private final Set<Character> usedCharacters;
    private int attempts;

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
