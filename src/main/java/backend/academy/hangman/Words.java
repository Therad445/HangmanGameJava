package backend.academy.hangman;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter public class Words {

    private List<String> wordsArray;
    private String usingWord;

    public Words(List<String> wordsArray) {
        this.wordsArray = wordsArray;
    }

    public String randomWord() {
        int indexRandomElement = (int) (Math.random() * wordsArray.size());
        return wordsArray.get(indexRandomElement);
    }
}
