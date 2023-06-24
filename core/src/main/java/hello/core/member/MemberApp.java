package hello.core.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", 20L, Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("new Member = " + member.getAge());
        System.out.println("findMember = " + findMember.getName());
        System.out.println("findMember = " + findMember.getAge());
    }
}
