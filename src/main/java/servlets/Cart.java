package servlets;

import dao.BusRepository;
import dao.CartRepository;
import entities.AbstractEntity;
import entities.Bus;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Ivan Ustinov(ivanustinov1985@yandex.ru)
 * @version 1.0
 * @since 10.09.2018
 */
@WebServlet(name = "Cart", urlPatterns = {"/cart"})
public class Cart extends HttpServlet {

    @Inject
    private CartRepository cartRepository;
    @Inject
    private BusRepository busRepository;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = doAction(request);
        HashMap<String, Integer> cart = cartRepository.findAll();
        HashMap<String, Bus> list = busRepository.findAll();
        int totalNumber = 0;
        double totalSumm = 0;
        if (cart.size() != 0) {
             totalNumber = cartRepository.calcTotalNumber(cart);
             totalSumm = cartRepository.calcTotalSumm(cart, list);
        }
        request.setAttribute("cart", cart);
        request.setAttribute("list", list);
        request.setAttribute("totalNumber", totalNumber);
        request.setAttribute("totalSumm", totalSumm);
        request.getRequestDispatcher(page).forward(request, response);
    }


    public String doAction(HttpServletRequest request) {
        String page = null;
        if (request.getParameterMap().isEmpty()) {
            page = "WEB-INF/views/cart.jsp";
        } else if (request.getParameter("action").equals("add")) {
            cartRepository.add(request.getParameter("id"));
        } else if (request.getParameter("action").equals("delete")) {
            cartRepository.delete(request.getParameter("id"));
        } else if (request.getParameter("action").equals("clearEntity")) {
            cartRepository.deleteEntity(request.getParameter("id"));
        } else if (request.getParameter("action").equals("clear")) {
            cartRepository.clear();
        }
        if (page == null) {
            page = request.getParameter("page");
        }
        return page;
    }
}
