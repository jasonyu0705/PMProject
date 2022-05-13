/*
Dieter Jason Matthew 5/12/22
Question class
attributes: question, option 1-4, answer
Used in the multiple choice test
 */
package pmproject;

/**
 *
 * @author jason
 */
public class Question {

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answer;
    private int userAnswer;

    /**
     * question constructor no parameters
     */
    public Question() {
        question = "";
        option1 = "";
        option2 = "";
        option3 = "";
        option4 = "";
        answer = 0;
        userAnswer = 0;
    }

    /**
     * question constructor includes all parameters
     *
     * @param q - string variable with question
     * @param o1 - first option
     * @param o2 - second option
     * @param o3 - third option
     * @param o4 - fourth option
     * @param a - answer integer 1-4
     * @param userA - user's answer as integer from 1-4
     */
    public Question(String q, String o1, String o2, String o3, String o4, int a, int userA) {
        this();
        question = q;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        answer = a;
        userAnswer = userA;
    }
    
    /**
     * Accessor method to get user's answer
     * @return user answer as integer from 1 to 4 for multiple choice selection
     */
    public int getUserAnswer(){
        return userAnswer;
    }
    
    /**
     * Mutator method to set user's answer
     * @param a - user answer as integer from 1 to 4 for multiple choice selection
     */
    public void setUserAnswer(int a){
        userAnswer = a;
    }
    
    public boolean correct(){
        return (userAnswer == answer); 
    }
    
    
    /**
     * accessor for the question
     *
     * @return - the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * accessor for each option
     *
     * @param n - which option to return 1-4
     * @return the option
     */
    public String getOption(int n) {
        if (n == 1) {
            return option1;
        } else if (n == 2) {
            return option2;
        } else if (n == 3) {
            return option3;
        } else {
            return option4;
        }
    }

    /**
     * accessor for the answer
     *
     * @return - the answer
     */
    public int getAnswer() {
        return answer;
    }

    /**
     * mutator for the question
     *
     * @param q - the new question
     */
    public void setQuestion(String q) {
        this.question = q;
    }

    /**
     * mutator for the option
     *
     * @param o - the new option
     * @param n - which option to replace
     */
    public void setOption(String o, int n) {
        if (n == 1) {
            this.option1 = o;
        } else if (n == 2) {
            this.option2 = o;
        } else if (n == 3) {
            this.option3 = o;
        } else {
            this.option4 = o;
        }
    }

    /**
     * mutator for the answer
     *
     * @param n - the new answer
     */
    public void setAnswer(int n) {
        this.answer = n;
    }

    /**
     * to string method returns string with all the question's info
     *
     * @return - the string
     */
    public String toString() {
        return question + "\n"
                + " a) " + option1
                + "\n b) " + option2
                + "\n c) " + option3
                + "\n d) " + option1;
    }

    /**
     * clone method returns a question with the same properties
     *
     * @return - cloned question
     */
    public Question clone() {
        Question q = new Question(question, option1, option2, option3, option4, answer, userAnswer);
        return q;
    }

    /**
     * equals method checks if two questions are the same
     *
     * @param q - question being checked
     * @return - boolean of if they are identical
     */
    public boolean equals(Question q) {
        if (this.question.equals(q.getQuestion()) && option1.equals(q.getOption(1)) && option1.equals(q.getOption(1)) && option2.equals(q.getOption(2)) && option3.equals(q.getOption(3)) && option4.equals(q.getOption(4)) && answer == q.getAnswer()) {
            return true;
        } else {
            return false;
        }
    }

}
