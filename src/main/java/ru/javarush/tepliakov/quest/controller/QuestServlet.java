package ru.javarush.tepliakov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.tepliakov.quest.model.Question;
import ru.javarush.tepliakov.quest.model.TypeMessege;
import ru.javarush.tepliakov.quest.service.QuestService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GuestServlet", value = "/start-quest")
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

        HttpSession session = req.getSession(true);

//        <a href="start-quest">Start</a>



        if (session.getAttribute("message") == null) {
            Question startQuestion = service.startSession();
            session.setAttribute("message", startQuestion);
        } else {
            Question question = (Question) session.getAttribute("message");
            question = service.printNext(question.getId());
            session.setAttribute("message", question);
        }



        // для отображения скрытых объектов
//        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        // для подгрузки новых значений
        resp.sendRedirect("/index.jsp");

//        Object jsonFile = session.getAttribute("json-road");
//        if (jsonFile == null) {
//            session.invalidate();
//            throw new RuntimeException("Session is broken, try one more time");
//        }
//        resp.setContentType("text/html");
//
//        // Hello
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + question.getText() + "</h1>");
//        out.println("</body></html>");

    }

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

    public void destroy() {
    }
}
