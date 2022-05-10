/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public Question() {
        question = "";
        option1 = "";
        option2 = "";
        option3 = "";
        option4 = "";
        answer = 0;
    }

    public Question(String q, String o1, String o2, String o3, String o4, int a) {
        super();
        question = q;
        option1 = o1;
        option2 = o2;
        option3 = o3;
        option4 = o4;
        answer = a;
    }
    
    public String getQuestion(){
        return question;
    }
    
    public String getOption(int n){
        if (n == 1){
            return option1;
        }else if (n==2){
            return option2;
        }else if (n==3){
            return option3;
        }else{
            return option4;
        }
    }
    public int getAnswer(){
        return answer;
    }
    public void setQuestion(String q){
        this.question=q;
    }
    public void setOption(String o, int n){
        if (n == 1){
            this.option1=o;
        }else if (n==2){
            this.option2=o;
        }else if (n==3){
            this.option3=o;
        }else{
            this.option4=o;
        }
    }
    public void setAnswer(int n){
        
    }

}

