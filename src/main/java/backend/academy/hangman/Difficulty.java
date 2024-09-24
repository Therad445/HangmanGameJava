package backend.academy.hangman;

import lombok.Getter;

public class Difficulty {

     private enum DifficultyLevel {
        EASY, MEDIUM, HARD;

    }

    private DifficultyLevel level;
    @Getter private int attempts;

    public Difficulty() {
        this.level = DifficultyLevel.EASY;
        this.attempts = 10;
    }

    public String getDifficulty() {
        return switch (level) {
            case EASY -> "EASY";
            case MEDIUM -> "MEDIUM";
            case HARD -> "HARD";
        };
    }

    public void setDifficulty(String level) {
        String upperLevel = level.toUpperCase();
        if (upperLevel.equals("ЛЕГКО")) {
            this.level = DifficultyLevel.EASY;
            this.attempts = 6;
        } else if (upperLevel.equals("СРЕДНЕ")) {
            this.level = DifficultyLevel.MEDIUM;
            this.attempts = 4;
        } else if (upperLevel.equals("СЛОЖНО")) {
            this.level = DifficultyLevel.HARD;
            this.attempts = 2;
        } else if (upperLevel.isEmpty()) {
            setDifficulty("ЛЕГКО");
        } else {
            throw new IllegalArgumentException("Invalid difficulty level: " + level);
        }
    }
}
