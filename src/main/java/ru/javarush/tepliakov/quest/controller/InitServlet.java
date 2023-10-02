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

        session.setAttribute("winCount", 0);

        getServletContext().getRequestDispatcher("/reset").forward(req, resp);
    }
}
