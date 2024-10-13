package backend.academy.hangman;

import lombok.experimental.UtilityClass;

@UtilityClass
public class HangmanPaint {
    private static final String[] HANGMAN_PAINT = {
        "",
        " O ",
        " O \n | ",
        " O \n/0 ",
        " O \n/0\\ ",
        " O \n/0\\ \n/ ",
        " O \n/0\\ \n/ \\"
    };
    private static final int MAX_ATTEMPTS = 6;

    public static String hangmanPaint(int attempts) {
        if (attempts > MAX_ATTEMPTS || attempts < 0) {
            throw new IllegalArgumentException(attempts + " - это неправильное количество попыток");
        }
        return HANGMAN_PAINT[MAX_ATTEMPTS - attempts];
    }
}
