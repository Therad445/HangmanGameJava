package backend.academy.hangman;

import lombok.Getter;
import lombok.Setter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
This class receive categoryArray and includes Category methods
*/

@Setter @Getter public class Categories {
    private List<String> categoriesArray;
    @Getter private String usingCategory;

    public Categories(List<String> categoriesArray) {
        this.categoriesArray = categoriesArray;
    }

    public Categories(Map<String, List<String>> hangmanWords) {
        this.categoriesArray = hangmanWords.keySet().stream().toList();
    }

    /*
    That method
    */
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
