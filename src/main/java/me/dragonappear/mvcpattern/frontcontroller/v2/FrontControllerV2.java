package me.dragonappear.mvcpattern.frontcontroller.v2;


import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.v2.impl.MemberFormControllerV2;
import me.dragonappear.mvcpattern.frontcontroller.v2.impl.MemberListControllerV2;
import me.dragonappear.mvcpattern.frontcontroller.v2.impl.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    private Map<String, ControllerV2> map = new HashMap<>();

    public FrontControllerV2() {
        map.put("/front-controller/v2/members/new-form",
                new MemberFormControllerV2());
        map.put("/front-controller/v2/members/save",
                new MemberSaveControllerV2());
        map.put("/front-controller/v2/members",
                new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        ControllerV2 controller = map.get(requestURI);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView view = controller.process(req, resp);

        view.render(req,resp);

    }
}
