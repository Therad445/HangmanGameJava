package backend.academy.hangman;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

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
