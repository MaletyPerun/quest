package ru.javarush.tepliakov.quest.model;

import java.util.List;


//@Getter
//@Setter
public class Message {

    private static int count = 0;

    private int id = 0;
    private TypeMessege type;
    private String text;
    private List<Integer> answers;

    public static long getCount() {
        return count;
    }

    public static void setCount(int count) {
        Message.count = count;
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

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public Message(int id, TypeMessege type, String text, List<Integer> answers) {
//        this.id = count++;
        this.id = id;
        this.type = type;
        this.text = text;
        this.answers = answers;
    }

    public Message(TypeMessege type, String text) {
        this.id = count++;
//        this.id = id;
        this.type = type;
        this.text = text;
    }
}
