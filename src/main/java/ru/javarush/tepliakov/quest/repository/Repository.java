package ru.javarush.tepliakov.quest.repository;

import ru.javarush.tepliakov.quest.model.Message;

import java.util.List;

public interface Repository {

    void init();

    Message getById();
    Message getById(int id);

    List<Message> getParentAndDescendant(int id);
}
