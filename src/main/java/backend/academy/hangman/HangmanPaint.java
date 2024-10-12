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

    static String hangmanPaint(int attempts) {
        return HANGMAN_PAINT[MAX_ATTEMPTS - attempts];
    }
}
