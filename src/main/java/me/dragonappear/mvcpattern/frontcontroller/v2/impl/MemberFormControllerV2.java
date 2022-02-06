package me.dragonappear.mvcpattern.frontcontroller.v2.impl;

import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.v2.ControllerV2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }
}
