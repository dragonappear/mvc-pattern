package me.dragonappear.mvcpattern.frontcontroller.v3.impl;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.domian.Member;
import me.dragonappear.mvcpattern.frontcontroller.repository.MemberRepository;
import me.dragonappear.mvcpattern.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, Object> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members",members);

        return modelView;
    }
}
