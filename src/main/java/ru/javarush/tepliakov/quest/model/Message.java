package ru.javarush.tepliakov.quest.model;

import java.util.List;

public class Message {

    private static int count = 0;

    private int id = 0;
    private TypeMessege type;
    private String text;
    private List<Integer> answers;

    public TypeMessege getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public Message(int id, TypeMessege type, String text, List<Integer> answers) {
        this.id = id;
        this.type = type;
        this.text = text;
        this.answers = answers;
    }
}
