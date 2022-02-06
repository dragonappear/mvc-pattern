package me.dragonappear.mvcpattern.frontcontroller.v3.impl;

import me.dragonappear.mvcpattern.frontcontroller.ModelView;
import me.dragonappear.mvcpattern.frontcontroller.domian.Member;
import me.dragonappear.mvcpattern.frontcontroller.repository.MemberRepository;
import me.dragonappear.mvcpattern.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, Object> paramMap) {
        String username = (String) paramMap.get("username");
        int age = Integer.parseInt((String)paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);

        return mv;

    }
}
