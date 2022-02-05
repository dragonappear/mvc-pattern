package me.dragonappear.mvcpattern.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
