package me.dragonappear.mvcpattern.frontcontroller.v3;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.ParamMapFactory;
import me.dragonappear.mvcpattern.frontcontroller.ViewResolver;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberFormControllerV3;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberListControllerV3;
import me.dragonappear.mvcpattern.frontcontroller.v3.impl.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerV3 extends HttpServlet {
    private Map<String, ControllerV3> map = new HashMap<>();

    public FrontControllerV3() {
        map.put("/front-controller/v3/members/new-form",
                new MemberFormControllerV3());
        map.put("/front-controller/v3/members/save",
                new MemberSaveControllerV3());
        map.put("/front-controller/v3/members",
                new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        ControllerV3 controller = map.get(requestURI);

        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, Object> paramMap = ParamMapFactory.createMap(req);
        ModelView mv = controller.process(paramMap);
        MyView view = ViewResolver.resolve(mv.getViewPath());

        view.render(mv.getModel(),req,resp);
    }
}
