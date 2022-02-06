package me.dragonappear.mvcpattern.frontcontroller.v4.impl;

import me.dragonappear.mvcpattern.frontcontroller.domian.Member;
import me.dragonappear.mvcpattern.frontcontroller.repository.MemberRepository;
import me.dragonappear.mvcpattern.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();

        model.put("members", members);

        return "members";
    }
}
