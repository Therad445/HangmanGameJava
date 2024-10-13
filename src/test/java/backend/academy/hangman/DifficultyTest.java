package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DifficultyTest {
    @Test
    public void choose_easyDifficulty() {
        //Arrange
        Difficulty difficulty = new Difficulty();
        //Act
        String testDifficulty = "Легко";
        difficulty.setDifficulty(testDifficulty);
        //Assert
        assertEquals(6, difficulty.attemptsLeft());
    }

    @Test
    public void choose_mediumDifficulty() {
        //Arrange
        Difficulty difficulty = new Difficulty();
        //Act
        String testDifficulty = "Средне";
        difficulty.setDifficulty(testDifficulty);
        //Assert
        assertEquals(4, difficulty.attemptsLeft());
    }

    @Test
    public void choose_hardDifficulty() {
        //Arrange
        Difficulty difficulty = new Difficulty();
        //Act
        String testDifficulty = "сложно";
        difficulty.setDifficulty(testDifficulty);
        //Assert
        assertEquals(2, difficulty.attemptsLeft());
    }

    @Test
    public void choose_nullDifficulty() {
        //Arrange
        Difficulty difficulty = new Difficulty();
        //Act
        String testDifficulty = "";
        difficulty.setDifficulty(testDifficulty);
        //Assert
        assertEquals(6, difficulty.attemptsLeft());
    }

    @Test
    public void choose_incorrectDifficulty() {
        //Arrange
        Difficulty difficulty = new Difficulty();
        //Act
        String testDifficulty = "Incorrect";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            difficulty.setDifficulty(testDifficulty);
        });
        //Assert
        assertEquals("Неверный уровень сложности: " + testDifficulty, exception.getMessage());
    }
}
