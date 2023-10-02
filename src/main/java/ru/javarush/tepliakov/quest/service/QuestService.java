package ru.javarush.tepliakov.quest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ru.javarush.tepliakov.quest.Constant;
import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.model.QuestTree;
import ru.javarush.tepliakov.quest.repository.Repository;
import ru.javarush.tepliakov.quest.repository.RepositoryImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class QuestService {

    private final String pathToJson = Constant.PATH_TO_JSON;
    private QuestTree tree;
    private Repository repository;

    public void init() {
        repository = new RepositoryImpl();
        repository.init();
//        tree = makeQuestTree();
    }

    private QuestTree makeQuestTree() {

        // TODO: 29.09.2023 правильно обработать исключение
        QuestTree questTree;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            questTree = objectMapper.readValue(new File(pathToJson), QuestTree.class);
        } catch (IOException e) {
            System.out.println("bad format or path to file");
            throw new RuntimeException(e);
        }
        return questTree;

    }

    public List<Message> getNextNode(int id) {
        return repository.getParentAndDescendant(id);
    }
}
