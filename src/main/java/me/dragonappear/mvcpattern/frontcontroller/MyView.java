package me.dragonappear.mvcpattern.frontcontroller;

import lombok.AllArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class MyView {
    private String viewPath;

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewPath).forward(request,response);
    }
}
