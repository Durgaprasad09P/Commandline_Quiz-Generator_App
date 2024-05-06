package quiz_generator;

import java.util.ArrayList;
import java.util.List;

// Class representing a quiz containing multiple questions
public class Quiz {
    String topic;
    private List<Question> questions;

    // Constructor to initialize the quiz with a topic and an empty list of questions
    public Quiz(String topic) {
        this.topic = topic;
        this.questions = new ArrayList<>();
    }

    public Quiz() {
    }

    // Method to add a question to the quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Getter method to retrieve the list of questions in the quiz
    public List<Question> getQuestions() {
        return questions;
    }
}
