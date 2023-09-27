package ru.javarush.tepliakov.quest.repository;

import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.model.TreeNode;
import ru.javarush.tepliakov.quest.model.TypeMessege;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryImpl implements Repository {

    private TreeNode treeNode;

    private List<Message> questionList;

//    @Override
//    public void init(String json) {
//        if (json == null) {
//            init();
//        }
//    }



    public void init() {
        Message question1 = new Message(0, TypeMessege.QUESTION, "Ты потерял память Принять вызов НЛО?", List.of(1, 2));
        Message question2 = new Message(1, TypeMessege.ANSWER, "Принять вызов", List.of(3));
        Message question3 = new Message(2, TypeMessege.LOOSE, "Отклонить вызов", List.of(12));

        Message question4 = new Message(3, TypeMessege.QUESTION, "Ты принял вызов. Поднимаешься на мостик к капитану?", List.of(4, 5));
        Message question5 = new Message(4, TypeMessege.ANSWER, "Подняться на мостик", List.of(6));
        Message question6 = new Message(5, TypeMessege.LOOSE, "Отказаться подниматься на мостик", List.of(11));

        Message question7 = new Message(6, TypeMessege.QUESTION, "Ты поднялся на мостик. Ты кто?", List.of(7 ,8));
        Message question8 = new Message(7, TypeMessege.ANSWER, "Рассказать правду о себе", List.of(9));
        Message question9 = new Message(8, TypeMessege.LOOSE, "Солгать о себе", List.of(10));

        Message question10 = new Message(9, TypeMessege.WIN, "Тебя вернули домой. Победа", Collections.emptyList());

        Message question11 = new Message(10, TypeMessege.LOOSE, "Твою ложь разоблачили. Поражение", Collections.emptyList());
        Message question12 = new Message(11, TypeMessege.LOOSE, "Ты не пошел на переговоры. Поражение", Collections.emptyList());
        Message question13 = new Message(12, TypeMessege.LOOSE, "Ты отклонил вызов. Поражение", Collections.emptyList());

        questionList = List.of(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9,
                question10,
                question11,
                question12,
                question13);
    }

    @Override
    public Message getById() {
        return questionList.get(0);
    }

    @Override
    public Message getById(int id) {
        return questionList.get(id);
    }

    @Override
    public List<Message> getParentAndDescendant(int id) {
        List<Message> parentAndDescendant = new ArrayList<>();
        Message message = questionList.get(id);
        parentAndDescendant.add(message);
        List<Integer> children = questionList.get(id).getAnswers();
        if (!children.isEmpty()) {
            for (int x :
                    children) {
                parentAndDescendant.add(questionList.get(x));
            }
        }
        return parentAndDescendant;
    }

}
