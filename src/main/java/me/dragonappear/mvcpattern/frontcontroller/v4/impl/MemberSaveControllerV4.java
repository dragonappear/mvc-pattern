package me.dragonappear.mvcpattern.frontcontroller.v4.impl;

import me.dragonappear.mvcpattern.frontcontroller.domian.Member;
import me.dragonappear.mvcpattern.frontcontroller.repository.MemberRepository;
import me.dragonappear.mvcpattern.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        String username = (String) paramMap.get("username");
        int age = Integer.parseInt((String) paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
