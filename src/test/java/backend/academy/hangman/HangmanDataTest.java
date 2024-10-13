package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HangmanDataTest {

    @Test
    public void correctSmall_hangmanData() {
        //Arrange
        Map<String, List<String>> words;
        words = Map.of("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"),
            "фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец"), "ягоды",
            Arrays.asList("клубника", "ежевика", "голубика", "брусника", "земляника"), "молочные продукты",
            Arrays.asList("сыр", "йогурт", "молоко", "масло", "кефир"));
        //Act
        //Assert
        assertEquals(HangmanData.getHangmanData(), words);
    }
}
