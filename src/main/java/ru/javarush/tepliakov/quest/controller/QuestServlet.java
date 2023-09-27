package ru.javarush.tepliakov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ru.javarush.tepliakov.quest.model.Message;
import ru.javarush.tepliakov.quest.model.TypeMessege;
import ru.javarush.tepliakov.quest.service.QuestService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {

    private QuestService service;

    private String message;

    public void init() {
//        message = "It`s quest space";
        service = new QuestService();
        service.init();
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.isNew()) {
//            setUp(session);
        }

        int param = getSelectedIndex(req);
//        int param = updateList != null ? getSelectedIndex(req) : 0;

        // TODO: 27.09.2023 передавать точечно объекты
          List<Message> currentList = extractCurrentList(session);

        if (param != 0) {
            Message message1 = currentList.get(param);
            int nextQuestionId = message1.getAnswers().get(0);
            currentList = service.getNextNode(nextQuestionId);
        }

        if (currentList.size() < 2 && currentList.get(0).getType() == TypeMessege.WIN) {
            session.setAttribute("win", true);
            int winCount = (Integer) session.getAttribute("winCount");
            session.setAttribute("winCount", winCount + 1);
            session.setAttribute("restart", "visible");
        }

        if (currentList.size() < 2 && currentList.get(0).getType() == TypeMessege.LOOSE) {
            session.setAttribute("loose", true);
            session.setAttribute("restart", "visible");
        }

        updateButtons(session, currentList);


//        List<Message> list = service.getNextNode(0);
        session.setAttribute("messages", currentList);
        resp.sendRedirect("/index.jsp");

//        int id;
//        List<Message> updateList = null;

//        if (session.isNew()) {
//            service.init();
//            updateList = service.getNextNode(0);
//            id = 0;
//            Cookie cookie = new Cookie("messageId", String.valueOf(id));
//            resp.addCookie(cookie);
//        } else {
//
//        }

        // как использовать параметр?
//        int param = updateList != null ? getSelectedIndex(req) : 0;
//        updateList = service.getNextNode(updateList.get(param).getId());
//        session.setAttribute("messages", updateList);


//        Cookie[] cookies = req.getCookies();
//        String value = null;
//
//        if (cookies != null) {
//            for (Cookie cookie :
//                    cookies) {
//                if (cookie.getName().equals("messageId")) {
//                    value = cookie.getValue();
//                }
//            }
//        }
//
//        if (value == null) {
//            value = "0";
//        }

//        session = req.getSession();
//        int messageId = Integer.parseInt(value);




//        <a href="start-quest">Start</a>



//        if (session.getAttribute("messages") == null) {
//            Message startQuestion = service.startSession();
//            session.setAttribute("messages", startQuestion);
//        } else {
//            Message question = (Message) session.getAttribute("messages");
//            question = service.printNext(question.getId());
//            session.setAttribute("messages", question);
//        }



        // для отображения скрытых объектов
//        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        // для подгрузки новых значений
//        resp.sendRedirect("/index.jsp");

    }

    private void updateButtons(HttpSession session, List<Message> currentList) {
        if (currentList.size() < 2) {
            session.setAttribute("button1", currentList.get(0).getText());
            session.setAttribute("button2", "");
        }
        else {
            session.setAttribute("button1", currentList.get(1).getText());
            session.setAttribute("button2", currentList.get(2).getText());
        }
    }

    private void setUp(HttpSession session) {
        session.setAttribute("win", false);
        session.setAttribute("loose", false);
        session.setAttribute("winCount", 0);
        session.setAttribute("restart", "hidden");
    }

    private List<Message> extractCurrentList(HttpSession session) {
       Object list = session.getAttribute("messages");
       if (list != null && ArrayList.class == list.getClass()) {
           return (List<Message>) list;
       } else
           return service.getNextNode(0);
    }

//    private Field extractField(HttpSession currentSession) {
//        Object fieldAttribute = currentSession.getAttribute("field");
//        if (Field.class != fieldAttribute.getClass()) {
//            logger.error("fieldAttribute is not Field class, invalidate session");
//            currentSession.invalidate();
//            throw new RuntimeException("Session is broken, try one more time");
//        }
//        return (Field) fieldAttribute;
//    }

//    private int getNextMessages(HttpSession session, int currentId) {
//        if (session.getAttribute("messages") != null && (session.getAttribute("messages") instanceof List)) {
//            List<Message> messages = (List<Message>) session.getAttribute("messages");
//            return messages.get(0).getId();
//        }
//    }

//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private int getSelectedIndex(HttpServletRequest req) {
        String click = String.valueOf(req.getParameter("button"));
        boolean isNumeric = click.chars().allMatch(Character::isDigit);
//        logger.info("isNumeric : {}", isNumeric);
        return isNumeric ? Integer.parseInt(click) : 0;
    }

    public void destroy() {
    }
}
