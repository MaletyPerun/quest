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

@WebServlet(name = "ResetServlet", value = "/reset")
public class ResetServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ResetServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("ResetServlet doGet /reset");

        HttpSession session = req.getSession();

        session.setAttribute("win", false);
        session.setAttribute("loose", false);
        session.setAttribute("newQuest", "visible");
        session.setAttribute("restart", "hidden");
        session.setAttribute("messages", null);
        session.setAttribute("message", null);
        session.setAttribute("button1", "");
        session.setAttribute("button1visibility", "hidden");
        session.setAttribute("button2", "");
        session.setAttribute("button2visibility", "hidden");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("ResetServlet doPost /reset");
        req.getSession().invalidate();
        resp.sendRedirect("/init");
    }
}
