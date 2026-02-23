import java.util.Random;

public class GameConfig {
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final int MAX_ATTEMPTS = 7;
    private static final int MAX_HINTS = 3;

    private final int targetNumber;

    public GameConfig() {
        Random random = new Random();
        this.targetNumber = MIN + random.nextInt(MAX - MIN + 1);
    }

    public int getTargetNumber() { return targetNumber; }
    public int getMaxAttempts() { return MAX_ATTEMPTS; }
    public int getMaxHints() { return MAX_HINTS; }

    public void showRules() {
        System.out.println("Guess a number between " + MIN + " and " + MAX + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}