package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 10.09.2018
 */
@WebServlet(name = "Main", urlPatterns = {"/main"})
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write("<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<title>Main</title>" +
                    "</head>" +
                    "<body>" +
                    "<h1 align='center'>MAIN</h1>" +
                    "<div align='center'>" +
                    "<a href='catalog'>Каталог</a><br>" +
                    "<a href='cart'>Корзина</a><br>" +
                    "<a href='order'>Заявка</a><br>" +
                    "<a href='product'>Товар</a><br>" +
                    "</div>" +
                    "</body>" +
                    "</html>");
        }
    }
}
