package backend.academy;

import backend.academy.hangman.Categories;
import backend.academy.hangman.Difficulty;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.Words;
import lombok.experimental.UtilityClass;
import java.util.Scanner;

@UtilityClass

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Categories categories = new Categories(HangmanGame.hangmanWords());
        System.out.println("Выберите категорию:" + categories.categoriesArray());
        String category = scanner.nextLine().toLowerCase();
        categories.usingCategory(category);
        System.out.println((categories.usingCategory()));

        System.out.println("Выберете сложность: [легко, средне, сложно]");
        Difficulty difficulties = new Difficulty();
        difficulties.setDifficulty(scanner.nextLine().toLowerCase());
        System.out.println(difficulties.getDifficulty());

        Words words = new Words(HangmanGame.hangmanWords().get(category));
        words.usingWord(words.randomWord());
        System.out.println("Слово выбрано.");

        HangmanGame game = new HangmanGame(categories.usingCategory(), words.usingWord(), difficulties.attempts(),
            difficulties.getDifficulty());
        System.out.println("Игра началась:");
        while (!game.gameOver()) {
            game.displayInfo();
            System.out.println("Ввведите букву:");
            char symbol = scanner.nextLine().charAt(0);
            game.inputChar(symbol);
        }
        scanner.close();
    }
}

