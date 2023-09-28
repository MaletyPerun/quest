package ru.javarush.tepliakov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(InitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("InitServlet doGet /init");
        HttpSession session = req.getSession(true);

        session.setAttribute("win", false);
        session.setAttribute("newQuest", "visible");
        session.setAttribute("loose", false);
        session.setAttribute("winCount", 0);
        session.setAttribute("restart", "hidden");
        session.setAttribute("messages", null);
        session.setAttribute("message", null);
        session.setAttribute("button1", "");
        session.setAttribute("button1visibility", "hidden");
        session.setAttribute("button2", "");
        session.setAttribute("button2visibility", "hidden");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
