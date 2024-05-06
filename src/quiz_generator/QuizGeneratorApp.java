package quiz_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class representing the command-line quiz generator application
public class QuizGeneratorApp {
    public static void main(String[] args) {
        QuizManager quizManager = new QuizManager();
        Scanner scanner = new Scanner(System.in);

       // Main loop for the application
        while (true) {
            System.out.println("\nWelcome to quiz_generator.Quiz Generator!");
            System.out.println("1. Create quiz_generator.Quiz");
            System.out.println("2. Add quiz_generator.Question to quiz_generator.Quiz");
            System.out.println("3. Take quiz_generator.Quiz");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

        // Read user choice from the command line
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Switch case to perform actions based on user choice
            switch (choice) {
                case 1:
                    System.out.print("Enter quiz topic: ");
                    String topic = scanner.nextLine();
                    quizManager.createQuiz(topic);
                    break;
                case 2:
                    System.out.print("Enter quiz topic: ");
                    String quizTopic = scanner.nextLine();
                    System.out.print("Enter question text: ");
                    String questionText = scanner.nextLine();
                    System.out.print("Enter number of options: ");
                    int numOptions = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    List<String> options = new ArrayList<>();
                    for (int i = 0; i < numOptions; i++) {
                        System.out.print("Enter option " + (i + 1) + ": ");
                        options.add(scanner.nextLine());
                    }
                    System.out.print("Enter correct option number: ");
                    int correctOption = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Question question = new Question(questionText, options, correctOption);
                    quizManager.addQuestion(quizTopic, question);
                    break;
                case 3:
                    quizManager.displayQuizzes();
                    System.out.print("Enter quiz topic to take: ");
                    String quizToTake = scanner.nextLine();
                    quizManager.takeQuiz(quizToTake);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
