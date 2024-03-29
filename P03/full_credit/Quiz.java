import java.util.Scanner;

public class Quiz{
    private Question[] questions;

    public Quiz(){
        loadQuiz();
    }
    public double takeQuiz(){
        double correctQuestions = 0;
        for(Question q : questions){
            System.out.println(q.toString());
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your answer? ");
            int proposedAnswer = scanner.nextInt();
            q.checkAnswer(proposedAnswer);
            if(q.checkAnswer(proposedAnswer) == true){
                correctQuestions++;
            }
        }
       return correctQuestions/questions.length;

     }

    private void loadQuiz(){

        this.questions = new Question []{
            new Question("What does UML stand for?", 
                new String[] {"User Modeling Language", "Unified Modeling language", "Unit Modeling Language", "Ultimate Modeling Language"}, 
                2),
            new Question("What does a constant declaration in java look like?",
                new String[] {"const int num = 1;", "constant static final int num = 1", "private static final int num = 1;", "private int num = 1;"}, 
                3),
        };
    }
}