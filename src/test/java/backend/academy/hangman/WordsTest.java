package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordsTest {
    @Test
    public void correctChoose_wordFromWords() {
        //Arrange
        List<String> testWordsArray = Arrays.asList("Java", "Python", "C");
        //Act
        Words words = new Words(testWordsArray);
        //Assert
        assertTrue(testWordsArray.contains(words.usingWord()));
    }
    @Test
    public void nullChoose_wordFromWords_() {
        //Arrange
        List<String> testWordsArray = null;
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Words words = new Words(testWordsArray);
        });
        //Assert
        assertEquals("Нужно указать слова", exception.getMessage());
    }
    @Test
    public void choose_wordFromWords_SecondTime() {
        //Arrange
        List<String> testWordsArray = List.of("Java");
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Words words = new Words(testWordsArray);
        });
        //Assert
        assertEquals("Слишком мало слов, чтобы выбор был случайным", exception.getMessage());
    }
}
