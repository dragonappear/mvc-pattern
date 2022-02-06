package me.dragonappear.mvcpattern.frontcontroller.v3;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, Object> paramMap);
}
