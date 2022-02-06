package me.dragonappear.mvcpattern.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    String process(Map<String, Object> paramMap, Map<String, Object> model);
}
