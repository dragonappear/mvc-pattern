package me.dragonappear.mvcpattern.frontcontroller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ModelView {
    private String viewPath;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewPath) {
        this.viewPath = viewPath;
    }
}
