public class Quizzer{
    public static void main(String args[]){
        try {
            Quiz quiz = new Quiz();
            double finalGrade =  quiz.takeQuiz() * 100;
            System.out.println("final grade: " + finalGrade);
        
        } catch (IllegalArgumentException e) {
            System.err.println("invalid quiz: " + e.getMessage()); 
            System.exit(-1);
        }
    }
}