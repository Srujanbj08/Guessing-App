import java.util.Scanner;

public class GuessingAPP {

    public static void main(String[] args) throws InvalidInputException {
        System.out.println("Welcome to the Guessing App");

        
        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintsUsed = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (attempts < config.getMaxAttempts()) {

                System.out.print("Enter your guess: ");

                
                int guess = ValidationService.validateInput(scanner.nextLine());
                attempts++;

                String result = GuessValidator.validateGuess(
                        guess, config.getTargetNumber());

                
                if (!"CORRECT".equals(result) && hintsUsed < config.getMaxHints()) {
                    hintsUsed++;
                    System.out.println(
                        HintService.generateHint(config.getTargetNumber(), hintsUsed)
                    );
                }

                System.out.println(result);

                if ("CORRECT".equals(result)) {
                    break;
                }
            }
        }
    }
}