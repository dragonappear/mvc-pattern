package me.dragonappear.mvcpattern.frontcontroller.v2;

import me.dragonappear.mvcpattern.frontcontroller.MyView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response);
}
