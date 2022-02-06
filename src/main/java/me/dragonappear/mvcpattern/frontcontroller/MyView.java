package me.dragonappear.mvcpattern.frontcontroller;

import lombok.AllArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
public class MyView {
    private String viewPath;

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewPath).forward(request,response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        putAttribute(model, request);
        request.getRequestDispatcher(viewPath).forward(request,response);
    }

    private void putAttribute(Map<String, Object> model, HttpServletRequest req) {
        model.forEach((key,value)->req.setAttribute(key,value));
    }
}
