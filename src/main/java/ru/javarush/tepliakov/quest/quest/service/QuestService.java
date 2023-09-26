package ru.javarush.tepliakov.quest.quest.service;

import ru.javarush.tepliakov.quest.quest.repository.Repository;
import ru.javarush.tepliakov.quest.quest.repository.RepositoryImpl;

public class QuestService {

    private Repository repository;
    private String json = "";
    public void init() {
        repository = new RepositoryImpl();
        repository.init(json);
    };
    public void startSession() {};
    public void rememberUser() {};
    public void showStatistic() {};
    public void startQuest() {};
    public void printNext() {};
    public void printLeft() {};
    public void restart() {};
}
