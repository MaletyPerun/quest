package ru.javarush.tepliakov.quest;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.tepliakov.quest.model.Question;
import ru.javarush.tepliakov.quest.model.TypeMessege;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

//        HttpSession session = request.getSession(true);

//        Question question = new Question(TypeMessege.QUESTION, "test message");
//        session.setAttribute("message", question);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}