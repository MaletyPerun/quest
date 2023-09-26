package ru.javarush.tepliakov.quest.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

import java.util.List;


//@Getter
//@Setter
public class Question {

    private static int count = 0;

    private int id = 0;
    private TypeMessege type;
    private String text;
    private List<Question> answers;

    public static long getCount() {
        return count;
    }

    public static void setCount(int count) {
        Question.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeMessege getType() {
        return type;
    }

    public void setType(TypeMessege type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Question> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Question> answers) {
        this.answers = answers;
    }

    public Question(int id, TypeMessege type, String text) {
//        this.id = count++;
        this.id = id;
        this.type = type;
        this.text = text;
    }
}
