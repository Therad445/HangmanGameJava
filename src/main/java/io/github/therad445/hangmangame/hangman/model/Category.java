package io.github.therad445.hangmangame.hangman.model;

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
            throw new IllegalArgumentException("Такая категория " + usingCategory + " не может быть выбрана");
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
}
