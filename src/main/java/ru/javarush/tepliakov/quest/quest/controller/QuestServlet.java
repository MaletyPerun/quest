package ru.javarush.tepliakov.quest.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.javarush.tepliakov.quest.quest.service.QuestService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GuestServlet", value = "/start-quest")
public class QuestServlet extends HttpServlet {

    private QuestService service;

    private String message;

    public void init() {
        message = "It`s quest space";
        service = new QuestService();
    }


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        Object jsonFile = session.getAttribute("json-road");
        if (jsonFile == null) {
            session.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        service.init();
        resp.setContentType("text/html");

        // Hello
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

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
