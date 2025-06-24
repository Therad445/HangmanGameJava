package io.github.therad445.hangmangame.hangman.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanGameTest {

    @Test
    public void choose_char_FirstTime() {
        //Arrange
        char symbol = 'е';
        //Act
        HangmanGame hangmanGame = new HangmanGame("продукты", "хлеб", 4);
        //Assert
        assertEquals(hangmanGame.inputChar(symbol), true);
    }
    @Test
    public void choose_char_SecondTime() {
        //Arrange
        char symbol = 'е';
        //Act
        HangmanGame hangmanGame = new HangmanGame("продукты", "хлеб", 4);
        hangmanGame.inputChar(symbol);
        //Assert
        assertEquals(hangmanGame.inputChar(symbol), false);
    }
    @Test
    public void incorrect_choose_char() {
        //Arrange
        char symbol = 'е';
        //Act
        HangmanGame hangmanGame = new HangmanGame("продукты", "хлеб", 4);
        hangmanGame.inputChar(symbol);
        //Assert
        assertEquals(hangmanGame.inputChar(symbol), false);
    }
}
