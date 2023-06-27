package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    //인터페이스 객체만을 사용하여 구체적인 클래스에는 의존하지 않게 함
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //스프링의 싱글톤 테스트를 위한 메서드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
