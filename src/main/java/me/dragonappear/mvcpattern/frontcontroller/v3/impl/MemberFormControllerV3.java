package me.dragonappear.mvcpattern.frontcontroller.v3.impl;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, Object> paramMap) {
        return new ModelView("new-form");
    }
}
