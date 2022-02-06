package me.dragonappear.mvcpattern.frontcontroller;

public class ViewResolver {

    public static MyView resolve(String viewPath) {
        return new MyView("/WEB-INF/views/" + viewPath + ".jsp");
    }
}
