package hello.core.member;

import hello.core.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", 20L, Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("new Member = " + member.getAge());
        System.out.println("findMember = " + findMember.getName());
        System.out.println("findMember = " + findMember.getAge());
    }
}
