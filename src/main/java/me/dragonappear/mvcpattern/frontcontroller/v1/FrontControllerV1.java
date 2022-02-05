package me.dragonappear.mvcpattern.frontcontroller.v1;

import me.dragonappear.mvcpattern.frontcontroller.v1.impl.MemberFormControllerV1;
import me.dragonappear.mvcpattern.frontcontroller.v1.impl.MemberListControllerV1;
import me.dragonappear.mvcpattern.frontcontroller.v1.impl.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerV1 extends HttpServlet {
    private HashMap<String, ControllerV1> map = new HashMap<>();

    public FrontControllerV1() {
        map.put("/front-controller/v1/members/new-form",
                new MemberFormControllerV1());
        map.put("/front-controller/v1/members/save",
                new MemberSaveControllerV1());
        map.put("/front-controller/v1/members",
                new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ControllerV1 controller = map.get(req.getRequestURI());
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controller.process(req,resp);
    }
}
