package io.github.therad445.hangmangame.hangman.ui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanPaintTest {
    @Test
    public void correct_hangmanPaint() {
        //Arrange
        int attempts = 0;
        //Act
        //Assert
        assertEquals(" O \n/0\\ \n/ \\", HangmanPaint.hangmanPaint(attempts));
    }
    @Test
    public void incorrectBig_hangmanPaint() {
        //Arrange
        int attempts = 7;
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HangmanPaint.hangmanPaint(attempts);
        });
        //Assert
        assertEquals(attempts + " - это неправильное количество попыток", exception.getMessage());
    }
    @Test
    public void incorrectSmall_hangmanPaint() {
        //Arrange
        int attempts = -1;
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            HangmanPaint.hangmanPaint(attempts);
        });
        //Assert
        assertEquals(attempts + " - это неправильное количество попыток", exception.getMessage());
    }
}
