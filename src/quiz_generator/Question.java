package quiz_generator;

import java.util.List;

    // Class representing a single question in the quiz
    public class Question {
    private String text;
    private List<String> options;
    private int correctOption;

    // Constructor to initialize the question with text, options, and correct option
    public Question(String text, List<String> options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }
        // Getter methods for accessing question text, options, and correct option
    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}
