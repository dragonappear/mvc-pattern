package me.dragonappear.mvcpattern.frontcontroller.v4.impl;

import me.dragonappear.mvcpattern.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {
    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
