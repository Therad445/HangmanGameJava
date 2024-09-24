package backend.academy.hangman;

public class HangmanPaint {
    private static final String[] hangmanPaint = {
        "",
        " O ",
        " O \n | ",
        " O \n/0 ",
        " O \n/0\\ ",
        " O \n/0\\ \n/ ",
        " O \n/0\\ \n/ \\"
    };
    private static final int maxAttempts = 6;

    public static String hangmanPaint(int attempts) {
        return hangmanPaint[maxAttempts - attempts];
    }
}
