package backend.academy.hangman;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HangmanPaint {
    private final String[] hangmanPaint = {
        "",
        " O ",
        " O \n | ",
        " O \n/0 ",
        " O \n/0\\ ",
        " O \n/0\\ \n/ ",
        " O \n/0\\ \n/ \\"
    };
    private final int maxAttempts = 6;

    public String hangmanPaint(int attempts) {
        if (attempts > maxAttempts || attempts < 0) {
            throw new IllegalArgumentException(attempts + " - это неправильное количество попыток");
        }
        return hangmanPaint[maxAttempts - attempts];
    }
}
