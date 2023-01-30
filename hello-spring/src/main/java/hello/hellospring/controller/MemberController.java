package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService; //new로 생성하면 여러군데에서 memberService를 갖다 쓰게 됨(?)

    @Autowired //생성자에 Autowired가 있으면 멤버서비스를 스프링이 스프링 컨테이너에 있는 멤버서비스를 가져다가 연결을 시켜준다.
    public MemberController(MemberService memberService) { //DI에서 생성자를 이용한 주입 형식
        this.memberService = memberService;
    }
}
