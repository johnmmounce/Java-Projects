public class Question{
    private static int nextQuestionNumber = 1;
    private final int questionNumber;
    private String question;
    private String answers [];
    private int rightAnswer;

    public Question(String question, String answers[], int rightAnswer){
        if(rightAnswer < 1 || rightAnswer > answers.length){
            throw new IllegalArgumentException("answer choice must be between 1 and " + answers.length);
        }
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
        this.questionNumber = nextQuestionNumber++;
    }

    public boolean checkAnswer(int answer){
        return answer == rightAnswer;
    }

    @Override
    public String toString() {
        return questionNumber + ". " + question + "\n" +
        "  1) " + answers[0] + "\n" +
        "  2) " + answers[1] + "\n" +
        "  3) " + answers[2] + "\n" +
        "  4) " + answers[3];
    }
}