package ru.javarush.tepliakov.quest.service;

import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.repository.Repository;
import ru.javarush.tepliakov.quest.repository.RepositoryImpl;

import java.util.List;

public class QuestService {

    private Repository repository;
    private String json = "";
    public void init() {
        repository = new RepositoryImpl();
//        repository.init(json);
        repository.init();
    };
    public Message startSession() {
        return repository.getById();
    };
    public void rememberUser() {};
    public void showStatistic() {};
    public void startQuest() {};
    public Message printNext(int id) {
        return repository.getById(id + 1);
    };
    public void printLeft() {};
    public void restart() {};

    public List<Message> getNextNode(int id) {
        return repository.getParentAndDescendant(id);
    }
}
