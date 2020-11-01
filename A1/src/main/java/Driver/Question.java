package Driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* QUESTION ABSTRACT CLASS
*/
public class Question {
    String context = null;
    boolean isMultipleChoice;
    
    Question() {
        super();
    }
    
    public boolean isMultipleChoice() {
        return isMultipleChoice;
    }
    
    
    public void setContext(String context) {
        this.context = context;
    }
    
    public String getContext() {     
        return context == null ? "Please set context first" : context;
    }
}

/*
* MULTIPLE CHOICE QUESTION CLASS
*/
class MultipleChoiceQuestion extends Question {
   Set<String> answers;
   
   public MultipleChoiceQuestion() {
       answers = new HashSet<>();
       this.isMultipleChoice = true;
   }
   
   public void setAnswers(List<String> answers) {
       for(String answer : answers) {
           this.answers.add(answer);
       }
   }
   
   public Set<String> getAnswers() {
       return answers;
   }
   
   public boolean isCorrect(List<String> studentAnswers) {
       
       for(String studentAnswer : studentAnswers) {
           if(!this.answers.contains(studentAnswer))
               return false;
       }
       return true;
   }
}

/*
* SINGLE CHOICE QUESTION CLASS
*/
class SingleChoiceQuestion extends Question {
    String answer;
    
    public SingleChoiceQuestion() {
        this.answer = null;
        this.isMultipleChoice = false;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    public String getAnswer() {
        return answer == null ? "Please set answer first" : answer;
    }
    
    public boolean isCorrect(String studentAnswer) {
        return this.answer.equals(studentAnswer);
    }
}