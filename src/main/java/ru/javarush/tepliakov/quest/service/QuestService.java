package ru.javarush.tepliakov.quest.service;

import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.repository.Repository;
import ru.javarush.tepliakov.quest.repository.RepositoryImpl;

import java.util.List;

public class QuestService {

    private Repository repository;
    public void init() {
        repository = new RepositoryImpl();
        repository.init();
    }
    public List<Message> getNextNode(int id) {
        return repository.getParentAndDescendant(id);
    }
}
