package me.dragonappear.mvcpattern.frontcontroller.v5;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.ViewResolver;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberFormControllerV3;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberListControllerV3;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberSaveControllerV3;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberFormControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberListControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberSaveControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v5.impl.ControllerV3Adapter;
import me.dragonappear.mvcpattern.frontcontroller.v5.impl.ControllerV4Adapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet {
    Map<String, Object> handlerMapping = new HashMap<>();
    List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerV5() {
        initHandlerMapping();
        initHandlerAdapters();
    }

    private void initHandlerMapping() {
        handlerMapping.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMapping.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMapping.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        handlerMapping.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMapping.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMapping.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3Adapter());
        handlerAdapters.add(new ControllerV4Adapter());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        Object handler = getHandler(requestURI);
        if (handler == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        if (adapter == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ModelView mv = adapter.handle(req, resp, handler);

        MyView view = ViewResolver.resolve(mv.getViewPath());
        view.render(mv.getModel(), req, resp);
    }

    private Object getHandler(String requestURI) {
        Object handler = handlerMapping.get(requestURI);
        return handler;
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)) {
                return handlerAdapter;
            }
        }
        return null;
    }
}
