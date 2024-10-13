package backend.academy.hangman;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.Getter;

public class Category {
    private final List<String> categoriesList;
    @Getter
    private String usingCategory;

    public Category(List<String> categoriesList) {
        if (categoriesList == null || categoriesList.isEmpty()) {
            throw new IllegalArgumentException("Нельзя передавать пустые категории");
        }
        this.categoriesList = categoriesList;
    }

    public Category(Map<String, List<String>> hangmanWords) {
        this(hangmanWords.keySet().stream().toList());
    }

    public String setUsingCategory(String usingCategory) {
        if (!categoriesList.contains(usingCategory)) {
            throw new IllegalArgumentException("Категория " + usingCategory + " не может быть выбрана");
        } else if (this.usingCategory != null) {
            throw new IllegalArgumentException("Категория уже выбрана!");
        } else {
            this.usingCategory = usingCategory;
        }
        return "Категория " + usingCategory + " успешно выбрана";
    }

    public List<String> getCategoriesList() {
        return Collections.unmodifiableList(categoriesList);
    }

    public List<String> randomizerCategories(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("You isn't choose categories in Array");
        }
        if (n > categoriesList.size()) {
            throw new IllegalArgumentException("You choose more categories than in Array");
        }
        Collections.shuffle(categoriesList);
        return categoriesList.subList(0, n);
    }
}
