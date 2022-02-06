package me.dragonappear.mvcpattern.frontcontroller.v2.impl;

import me.dragonappear.mvcpattern.frontcontroller.MyView;
import me.dragonappear.mvcpattern.frontcontroller.domian.Member;
import me.dragonappear.mvcpattern.frontcontroller.repository.MemberRepository;
import me.dragonappear.mvcpattern.frontcontroller.v2.ControllerV2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");

    }
}
