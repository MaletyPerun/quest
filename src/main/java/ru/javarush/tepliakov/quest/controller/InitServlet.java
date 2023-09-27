package ru.javarush.tepliakov.quest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet (name = "InitServlet", value = "/init")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);

        session.setAttribute("win", false);
        session.setAttribute("loose", false);
        session.setAttribute("winCount", 0);
        session.setAttribute("restart", "hidden");

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
