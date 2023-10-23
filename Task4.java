import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    private String question;
    private List<String> options;
    private int correctOption;

    public Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

public class Task4 {
    private List<Question> questions = new ArrayList<>();
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Timer timer;
    private boolean answered = true;

    public Task4() {
        initializeQuestions();
    }

    public void startGame() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }

        System.out.println("Welcome to the Java Quiz!");
        System.out.println("You have 10 seconds to answer each question.\n");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!answered) {
                    System.out.println("Time's up! Moving to the next question.");
                    displayNextQuestion();
                }
            }
        }, 0, 10000);

        displayNextQuestion();
    }

    private void initializeQuestions() {
        // Add 12 Java-related questions with options and correct answers here
        questions.add(new Question("What is Java?", List.of("A. A coffee brand", "B. A programming language", "C. An island", "D. A car model"), 1));
        questions.add(new Question("Which keyword is used to define a constant in Java?", List.of("A. const", "B. static", "C. final", "D. constant"), 2));
        questions.add(new Question("What is the correct way to declare a variable in Java?", List.of("A. var name;", "B. variable name;", "C. int name;", "D. String name;"), 3));
        questions.add(new Question("Which loop is used to iterate over an array or a collection in Java?", List.of("A. for", "B. while", "C. do-while", "D. loop"), 0));
        questions.add(new Question("In Java, which data type is used to store whole numbers?", List.of("A. double", "B. float", "C. int", "D. char"), 2));
        questions.add(new Question("What is the entry point for a Java application?", List.of("A. main()", "B. start()", "C. run()", "D. execute()"), 0));
        questions.add(new Question("Which Java access modifier is the most restrictive?", List.of("A. protected", "B. private", "C. public", "D. default"), 1));
        questions.add(new Question("In Java, an interface can have concrete methods.", List.of("A. True", "B. False"), 1));
        questions.add(new Question("Which of the following is a valid way to create a thread in Java?", List.of("A. Thread myThread = new Thread();", "B. Thread myThread = createThread();", "C. Thread myThread = startThread();", "D. Thread myThread();"), 0));
        questions.add(new Question("What is the default value of a boolean variable in Java?", List.of("A. false", "B. true", "C. null", "D. 0"), 0));
        questions.add(new Question("In Java, which exception is thrown when an array index is out of bounds?", List.of("A. ArrayIndexOutOfBoundsException", "B. OutOfBoundsException", "C. IndexOutOfRangeException", "D. ArrayOutOfBoundsException"), 0));
        questions.add(new Question("What is the purpose of the 'break' statement in Java?", List.of("A. To exit a loop or switch statement", "B. To skip the next iteration of a loop", "C. To resume execution after a catch block", "D. To create a new block of code"), 0));
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            answered = false;
            Question question = questions.get(currentQuestionIndex);
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.flush();
        } else {
            endGame();
        }
    }

    public void processAnswer(String userChoice) {
        if (answered) {
            System.out.println("You've already answered this question.");
            return;
        }

        if (currentQuestionIndex < questions.size()) {
            int userAnswer = userChoice.charAt(0) - 'A';
            Question question = questions.get(currentQuestionIndex);
            if (userAnswer == question.getCorrectOption()) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect!\n");
            }

            answered = true;
            currentQuestionIndex++;
            if (currentQuestionIndex < questions.size()) {
                displayNextQuestion();
            } else {
                endGame();
            }
        }
    }

    private void endGame() {
        timer.cancel();
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + " out of " + questions.size());
    }

    public static void main(String[] args) {
        Task4 quiz = new Task4();
        quiz.startGame();

        Scanner scanner = new Scanner(System.in);
        while (quiz.currentQuestionIndex < quiz.questions.size()) {
            String userChoice = scanner.nextLine().trim().toUpperCase();
            quiz.processAnswer(userChoice);
        }

        scanner.close();
    }
}
