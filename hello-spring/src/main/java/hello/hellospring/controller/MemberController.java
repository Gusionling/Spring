package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService; //new로 생성하면 여러군데에서 memberService를 갖다 쓰게 됨(?)

    @Autowired //생성자에 Autowired가 있으면 멤버서비스를 스프링이 스프링 컨테이너에 있는 멤버서비스를 가져다가 연결을 시켜준다.
    public MemberController(MemberService memberService) { //DI에서 생성자를 이용한 주입 형식
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){ //spring이 memberForm에 있는 setName을 다해줌
        Member member = new Member();
        member.setName(form.getName());
        //멤버가 만들어졌다.
        memberService.join(member);

        return "redirect:/"; //redirect로 홈화면으로 보내버리는 것이다.
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); //멤버를 model에 담아서 화면에 넘길 것이다.
        return "members/memberList";
    }
}
