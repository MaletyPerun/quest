package ru.javarush.tepliakov.quest.repository;

import ru.javarush.tepliakov.quest.model.Question;
import ru.javarush.tepliakov.quest.model.TreeNode;
import ru.javarush.tepliakov.quest.model.TypeMessege;

import java.util.List;

public class RepositoryImpl implements Repository {

    private TreeNode treeNode;

    private List<Question> questionList;

//    @Override
//    public void init(String json) {
//        if (json == null) {
//            init();
//        }
//    }



    public void init() {
        Question question1 = new Question(1, TypeMessege.QUESTION, "Ты потерял память Принять вызов НЛО?");
        Question question2 = new Question(2, TypeMessege.QUESTION, "Принять вызов");
        Question question3 = new Question(3, TypeMessege.QUESTION, "Отклонить вызов");
        Question question4 = new Question(4, TypeMessege.QUESTION, "Ты принял вызов. Поднимаешся на мостик к капитану?");
        Question question5 = new Question(5, TypeMessege.QUESTION, "Подняться на мостик");
        Question question6 = new Question(6, TypeMessege.QUESTION, "Отказаться подниматься на мостик");
        Question question7 = new Question(7, TypeMessege.QUESTION, "Ты поднялся на мостик. Ты кто?");
        Question question8 = new Question(8, TypeMessege.QUESTION, "Рассказать правду о себе");
        Question question9 = new Question(9, TypeMessege.QUESTION, "Солгать о себе");
        Question question10 = new Question(10, TypeMessege.FINISH, "Тебя вернули домой. Победа");
        Question question11 = new Question(11, TypeMessege.FINISH, "Твою ложь разоблачили. Поражение");

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
                question11);
    }

    @Override
    public Question getById() {
        return questionList.get(0);
    }

    @Override
    public Question getById(int id) {
        return questionList.get(id);
    }

}
