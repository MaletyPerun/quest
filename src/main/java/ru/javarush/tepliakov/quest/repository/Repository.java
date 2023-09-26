package ru.javarush.tepliakov.quest.repository;

import ru.javarush.tepliakov.quest.model.Question;

public interface Repository {

    void init();

    Question getById();
    Question getById(int id);
}
