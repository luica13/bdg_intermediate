package com.bdg.servlets;

import com.bdg.models.User;
import com.bdg.repositories.UserRepository;
import com.bdg.repositories.UserRepositoryInMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository = new UserRepositoryInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userRepository.findAll();
        request.setAttribute("usersFromServer", users);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/jsp/signUp.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birthDate");
        String password = request.getParameter("password");
        User user = new User(name, password, LocalDate.parse(birthDate));
        userRepository.save(user);
        doGet(request, response);
    }
}
