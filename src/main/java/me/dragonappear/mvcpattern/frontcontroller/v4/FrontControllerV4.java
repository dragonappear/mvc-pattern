package me.dragonappear.mvcpattern.frontcontroller.v4;

import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.ParamMapFactory;
import me.dragonappear.mvcpattern.frontcontroller.ViewResolver;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberFormControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberListControllerV4;
import me.dragonappear.mvcpattern.frontcontroller.v4.impl.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerV4 extends HttpServlet {
    private Map<String, ControllerV4> map = new HashMap<>();

    public FrontControllerV4() {
        map.put("/front-controller/v4/members/new-form",
                new MemberFormControllerV4());
        map.put("/front-controller/v4/members/save",
                new MemberSaveControllerV4());
        map.put("/front-controller/v4/members",
                new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();

        ControllerV4 controller = map.get(requestURI);
        if (controller == null) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, Object> model = new HashMap<>();
        Map<String, Object> paramMap = ParamMapFactory.createMap(req);
        String viewPath = controller.process(paramMap, model);

        MyView view = ViewResolver.resolve(viewPath);

        view.render(model,req,resp);
    }
}
