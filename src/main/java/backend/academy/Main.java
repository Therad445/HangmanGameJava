package backend.academy;

import backend.academy.hangman.Category;
import backend.academy.hangman.Difficulty;
import backend.academy.hangman.HangmanGame;
import backend.academy.hangman.Words;
import java.util.Scanner;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Category categories = new Category(Words.getHangmanWords());
            log.info("Выберите категорию:\n{}", String.join(", ", categories.getCategoriesList()));
            String category = scanner.nextLine().toLowerCase();
            log.info((categories.setUsingCategory(category)));

            log.info("Выберете сложность:\nлегко, средне, сложно");
            Difficulty difficulties = new Difficulty();
            difficulties.setDifficulty(scanner.nextLine().toLowerCase());

            Words words = new Words(Words.getHangmanWords().get(category));
            log.info("Слово выбрано.");

            HangmanGame game = new HangmanGame(categories.usingCategory(), words.usingWord(), difficulties.attemptsLeft());
            log.info("Игра началась:");
            while (!game.gameOver()) {
                game.displayInfo();
                log.info("Ввведите букву:");
                char symbol = scanner.nextLine().charAt(0);
                game.inputChar(symbol);
            }
        }
        catch (Exception e) {
            log.error("Произошла ошибка: {}", e.getMessage());
        }
    }
}

