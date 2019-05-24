package servlets;

import dao.BusRepository;
import dao.ImageRepository;
import entities.Bus;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 10.09.2018
 */
@WebServlet(name = "Product", urlPatterns = {"/product"})
public class Product extends HttpServlet {
    @Inject
    private BusRepository busRepository;
    @Inject
    private ImageRepository imageRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Bus bus = busRepository.findEntityById(id);
        request.setAttribute("product", bus);
        request.setAttribute("image", imageRepository.getImage(bus.getModel()));
        request.getRequestDispatcher("WEB-INF/views/product.jsp").forward(request, response);
    }
}
