package backend.academy.hangman;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Category {
    private List<String> categoriesArray;
    private String usingCategory;

    public Category(List<String> categoriesArray) {
        this.categoriesArray = categoriesArray;
    }

    public Category(Map<String, List<String>> hangmanWords) {
        this.categoriesArray = hangmanWords.keySet().stream().toList();
    }


    public List<String> randomizerCategories(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("You isn't choose categories in Array");
        }
        if (n > categoriesArray.size()) {
            throw new IllegalArgumentException("You choose more categories than in Array");
        }
        Collections.shuffle(categoriesArray);
        return categoriesArray.subList(0, n);
    }
}
