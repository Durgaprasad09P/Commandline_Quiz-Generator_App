package quiz_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class responsible for managing quizzes, questions, and quiz-taking process
public class QuizManager {
    private List<Quiz> quizzes;
    private Scanner scanner;

    // Constructor to initialize the list of quizzes and a scanner for user input
    public QuizManager() {
        quizzes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to create a new quiz with the specified topic
    public void createQuiz(String topic) {
        Quiz quiz = new Quiz(topic);
        quizzes.add(quiz);
        System.out.println("quiz_generator.Quiz '" + topic + "' created successfully.");
    }

    // Method to add a question to an existing quiz
    public void addQuestion(String topic, Question question) {
        for (Quiz quiz : quizzes) {
            if (quiz.topic.equals(topic)) {
                quiz.addQuestion(question);
                System.out.println("quiz_generator.Question added to quiz '" + topic + "'.");
                return;
            }
        }
        System.out.println("quiz_generator.Quiz '" + topic + "' not found.");
    }

    // Method to display the list of available quizzes
    public void displayQuizzes() {
        System.out.println("Available quizzes:");
        for (Quiz quiz : quizzes) {
            System.out.println("- " + quiz.topic);
        }
    }

    // Method to take a quiz by displaying questions and recording user answers
    public void takeQuiz(String topic) {
        for (Quiz quiz : quizzes) {
            if (quiz.topic.equals(topic)) {
                int score = 0;
                int totalQuestions = quiz.getQuestions().size();
                System.out.println("quiz_generator.Quiz: " + topic);
                System.out.println("Total questions: " + totalQuestions);
                System.out.println("Answer the following questions:");

                for (Question question : quiz.getQuestions()) {
                    System.out.println(question.getText());
                    List<String> options = question.getOptions();
                    for (int i = 0; i < options.size(); i++) {
                        System.out.println((i + 1) + ". " + options.get(i));
                    }
                    System.out.print("Your choice: ");
                    int userChoice = scanner.nextInt();
                    if (userChoice == question.getCorrectOption()) {
                        score++;
                    }
                }

                System.out.println("\nquiz_generator.Quiz complete!");
                System.out.println("Your score: " + score + "/" + totalQuestions);
                return;
            }
        }
        System.out.println("quiz_generator.Quiz '" + topic + "' not found.");
    }
}
