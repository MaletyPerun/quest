package ru.javarush.tepliakov.quest.model;

import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
public class QuestTree {

    private String question;
    private String answer1;
    private QuestTree next1;
    private String answer2;
    private QuestTree next2;
    private TypeMessege finish;

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public QuestTree getNext1() {
        return next1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public QuestTree getNext2() {
        return next2;
    }

    public TypeMessege getFinish() {
        return finish;
    }
}
