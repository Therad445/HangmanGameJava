package backend.academy.hangman;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CategoryTest {
    @Test
    public void correct_usingCategory_Test() {
        //Arrange
        Map<String, List<String>> words = new HashMap<>();
        words.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"));
        words.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец"));
        Category category = new Category(words);
        //Act
        String categoryString = "животные";
        category.setUsingCategory(categoryString);
        //Assert
        assertEquals(category.usingCategory(), categoryString);
    }
    @Test
    public void incorrect_usingCategory_Test() {
        //Arrange
        Map<String, List<String>> words = new HashMap<>();
        words.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"));
        words.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец"));
        Category category = new Category(words);
        //Act
        String categoryString = "жив";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            category.setUsingCategory(categoryString);
        });
        //Assert
        assertEquals("Категория " + categoryString + " не может быть выбрана", exception.getMessage());
    }
    @Test
    public void null_usingCategory_Test() {
        //Arrange
        Map<String, List<String>> words = new HashMap<>();
        words.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"));
        words.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец"));
        Category category = new Category(words);
        //Act
        String categoryString = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            category.setUsingCategory(categoryString);
        });
        //Assert
        assertEquals("Категория " + categoryString + " не может быть выбрана", exception.getMessage());
    }
    @Test
    public void correct_CategoriesList_Test() {
        //Arrange
        Map<String, List<String>> words = new HashMap<>();
        words.put("животные", Arrays.asList("носорог", "тигр", "жираф", "кенгуру", "лошадь", "кит", "лягушка"));
        words.put("фрукты", Arrays.asList("яблоко", "грейпфрукт", "апельсин", "мандарин", "груша", "огурец"));
        //Act
        Category category = new Category(words);
        //Assert
        List<String> categories = List.of("животные", "фрукты");
        assertEquals(category.getCategoriesList(), categories);
    }
    @Test
    public void null_CategoriesList_Test() {
        //Arrange
        Map<String, List<String>> words = new HashMap<>();
        //Act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Category category = new Category(words);
        });
        //Assert
        assertEquals("Нельзя передавать пустые категории", exception.getMessage());
    }
}
