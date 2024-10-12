package backend.academy.hangman;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JunitTest {
    @Nested
    class CategoryTest {
        @Test
        public void choose_AllFromAllCategory() {
            //Arrange
            List<String> testCategoriesArray = Arrays.asList("Books", "Films");
            Category categories = new Category(testCategoriesArray);
            //Act
            List<String> randomizedCategories = categories.randomizerCategories(2);
            //Assert
            assertThat(randomizedCategories).isEqualTo(testCategoriesArray);
        }

        @Test
        public void choose_MoreFromLessCategory() {
            //Arrange
            List<String> testCategory = Arrays.asList("Books", "Films");
            Category categories = new Category(testCategory);
            //Act
            Exception error = assertThrows(IllegalArgumentException.class, () -> {
                categories.randomizerCategories(3);
            });
            //Assert
            assertEquals("You choose more categories than in Array", error.getMessage());
        }

        @Test
        public void choose_OneFromAllCategory() {
            //Arrange
            List<String> testCategory = Arrays.asList("Books", "Films");
            Category categories = new Category(testCategory);
            //Act
            List<String> randomizedCategories = categories.randomizerCategories(1);
            //Assert
            assertEquals(1, randomizedCategories.size());
//            assertTrue(categories.contains(categories.getFirst()));
        }

        @Test
        public void choose_NoneFromAllCategory() {
            //Arrange
            List<String> testCategory = Arrays.asList("Books", "Films");
            Category categories = new Category(testCategory);
            //Act
            Exception error = assertThrows(IllegalArgumentException.class, () -> {
                categories.randomizerCategories(0);
            });
            //Assert
            assertEquals("You isn't choose categories in Array", error.getMessage());
        }
    }

    @Nested
    class DifficultyTest {
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
            assertEquals("Invalid difficulty level: " + testDifficulty, exception.getMessage());
        }
    }

    @Nested
    class WordsTest {
        @Test
        public void choose_wordFromWords() {
            //Arrange
            List<String> testWordsArray = Arrays.asList("Java", "Python", "C");
            Words words = new Words(testWordsArray);
            //Act
            String word = words.randomWord();
            //Assert
            assertTrue(testWordsArray.contains(word));
        }
    }
}
