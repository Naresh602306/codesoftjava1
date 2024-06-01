import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    private static final int TIMER_DURATION = 10; // Adjust as needed

    public static void main(String[] args) {
        List<Question> questions = createQuestions();
        int score = 0;

        for (Question question : questions) {
            score += askQuestion(question);
        }

        showResults(score, questions.size());
    }

    private static List<Question> createQuestions() {
        // Replace with your actual questions and options
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?",
                new String[]{"London", "Paris", "Berlin", "India"}, 1));
        // ... add more questions
        return questions;
    }

    private static int askQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        Timer timer = new Timer();

        System.out.println(question.getQuestion());
        for (int i = 0; i < question.getOptions().length; i++) {
            System.out.println((i + 1) + ". " + question.getOptions()[i]);
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Time's up!");
                scanner.close();
            }
        }, TIMER_DURATION * 1000);

        int answer = scanner.nextInt() - 1;

        if (answer == question.getAnswerIndex()) {
            System.out.println("Correct!");
            return 1;
        } else {
            System.out.println("Incorrect. The correct answer is: " + question.getOptions()[question.getAnswerIndex()]);
            return 0;
        }
    }

    private static void showResults(int score, int totalQuestions) {
        System.out.println("Your final score is: " + score + "/" + totalQuestions);
    }

    static class Question {
        private String question;
        private String[] options;
        private int answerIndex;

        public Question(String question, String[] options, int answerIndex) {
            this.question = question;
            this.options = options;
            this.answerIndex = answerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public int getAnswerIndex() {
            return answerIndex;
        }
    }
}