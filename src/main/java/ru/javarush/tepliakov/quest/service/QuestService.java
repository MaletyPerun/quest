package ru.javarush.tepliakov.quest.service;

import ru.javarush.tepliakov.quest.model.Question;
import ru.javarush.tepliakov.quest.repository.Repository;
import ru.javarush.tepliakov.quest.repository.RepositoryImpl;

public class QuestService {

    private Repository repository;
    private String json = "";
    public void init() {
        repository = new RepositoryImpl();
//        repository.init(json);
        repository.init();
    };
    public Question startSession() {
        return repository.getById();
    };
    public void rememberUser() {};
    public void showStatistic() {};
    public void startQuest() {};
    public Question printNext(int id) {
        return repository.getById(id + 1);
    };
    public void printLeft() {};
    public void restart() {};
}
