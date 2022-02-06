package me.dragonappear.mvcpattern.frontcontroller.v5;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MyHandlerAdapter {
    boolean supports(Object handler);

    ModelView handle(HttpServletRequest request, HttpServletResponse response,Object handler);
}
