package me.dragonappear.mvcpattern.frontcontroller.v5.impl;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.ParamMapFactory;
import me.dragonappear.mvcpattern.frontcontroller.v4.ControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4Adapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ControllerV4 controller = (ControllerV4) handler;

        Map<String, Object> paramMap = ParamMapFactory.createMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewPath = controller.process(paramMap, model);
        ModelView mv = new ModelView(viewPath);
        mv.setModel(model);

        return mv;
    }
}
