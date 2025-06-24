package io.github.therad445.hangmangame;

import io.github.therad445.hangmangame.hangman.model.Category;
import io.github.therad445.hangmangame.hangman.model.Difficulty;
import io.github.therad445.hangmangame.hangman.repository.HangmanData;
import io.github.therad445.hangmangame.hangman.service.HangmanGame;
import io.github.therad445.hangmangame.hangman.model.Words;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@UtilityClass
@Log4j2
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {

            Category categories = new Category(HangmanData.getHangmanData());
            log.info("Выберите категорию:\n{}", String.join(", ", categories.getCategoriesList()));
            String category = scanner.nextLine().toLowerCase();
            log.info((categories.setUsingCategory(category)));

            log.info("Выберете сложность:\nлегко, средне, сложно");
            Difficulty difficulties = new Difficulty();
            difficulties.setDifficulty(scanner.nextLine().toLowerCase());

            Words words = new Words(HangmanData.getHangmanData().get(category));
            log.info("Слово выбрано.");

            HangmanGame game = new HangmanGame(categories.usingCategory(), words.usingWord(),
                difficulties.attemptsLeft());
            log.info("Игра началась:");
            while (!game.gameOver()) {
                game.displayInfo();
                log.info("Ввведите букву:");
                char symbol = scanner.nextLine().charAt(0);
                game.inputChar(symbol);
            }
        } catch (Exception e) {
            log.error("Произошла ошибка: {}", e.getMessage());
        }
    }
}

