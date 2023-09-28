package ru.javarush.tepliakov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.model.TypeMessege;
import ru.javarush.tepliakov.quest.service.QuestService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    private QuestService service;

    public void init() {
        service = new QuestService();
        service.init();
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // извлечение значение из параметра button (?button=1)
        int param = getSelectedIndex(req);
        boolean isFinish = false;

        List<Message> currentList = extractCurrentList(session);

        if (param != 0) {
            Message message1 = currentList.get(param);
            int nextQuestionId = message1.getAnswers().get(0);
            currentList = service.getNextNode(nextQuestionId);
        }

        Message message1 = currentList.get(0);

        session.setAttribute("message", message1.getText());

        if (currentList.size() < 2 && currentList.get(0).getType() == TypeMessege.WIN) {
            session.setAttribute("win", true);
            int winCount = getCountWin(session);
            session.setAttribute("winCount", winCount + 1);
            session.setAttribute("restart", "visible");
            isFinish = true;
        }

        if (currentList.size() < 2 && currentList.get(0).getType() == TypeMessege.LOOSE) {
            session.setAttribute("loose", true);
            session.setAttribute("restart", "visible");
            isFinish = true;

        }

        updateButtons(session, currentList, isFinish);


        session.setAttribute("messages", currentList);
        session.setAttribute("newQuest", "hidden");
        resp.sendRedirect("/index.jsp");
    }

    private void updateButtons(HttpSession session, List<Message> currentList, boolean isFinish) {
        if (isFinish) {
            session.setAttribute("button1", "");
            session.setAttribute("button1visibility", "hidden");

            session.setAttribute("button2", "");
            session.setAttribute("button2visibility", "hidden");
            return;
        }
        if (currentList.size() < 2) {
            session.setAttribute("button1", currentList.get(0).getText());
            session.setAttribute("button1visibility", "visible");

            session.setAttribute("button2", "");
            session.setAttribute("button2visibility", "hidden");

        } else {
            session.setAttribute("button1", currentList.get(1).getText());
            session.setAttribute("button1visibility", "visible");

            session.setAttribute("button2", currentList.get(2).getText());
            session.setAttribute("button2visibility", "visible");

        }
    }

    private List<Message> extractCurrentList(HttpSession session) {
        Object list = session.getAttribute("messages");
        if (list != null && ArrayList.class == list.getClass()) {
            return (List<Message>) list;
        } else
            return service.getNextNode(0);
    }

    private int getSelectedIndex(HttpServletRequest req) {
        String click = String.valueOf(req.getParameter("button"));
        boolean isNumeric = click.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(click) : 0;
    }

    private int getCountWin(HttpSession session) {
        Object count = session.getAttribute("winCount");
        if (count == null) {
            return 0;
        } else {
            return (Integer) count;
        }
    }
}
