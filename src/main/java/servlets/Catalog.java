package servlets;

import dao.BusRepository;
import dao.CartRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 10.09.2018
 */
@WebServlet(name = "Catalog", urlPatterns = {"/catalog"})
public class Catalog extends HttpServlet {

    @Inject
    private BusRepository busRepository;

    @Inject
    private CartRepository cartRepository;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Integer> cart = cartRepository.findAll();
        request.setAttribute("cart", cart);
        request.setAttribute("list", busRepository.findAll());
        request.setAttribute("totalSumm", cartRepository.calcTotalSumm(cart, busRepository.findAll()));
        request.setAttribute("totalNumber", cartRepository.calcTotalNumber(cart));
        request.getRequestDispatcher("WEB-INF/views/catalog.jsp").forward(request, response);
    }
}
