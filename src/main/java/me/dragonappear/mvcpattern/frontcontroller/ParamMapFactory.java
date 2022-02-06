package me.dragonappear.mvcpattern.frontcontroller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ParamMapFactory {

    public static Map<String, Object> createMap(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(name -> map.put(name, request.getParameter(name)));

        return map;
    }
}
