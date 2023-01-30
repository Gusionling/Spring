package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService { //비즈니스 로직을 만드는 작업

    //회원서비스가 있으려면 회원 리포지토리가 있어야 한다.
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { //memberRepository를 new해서 직접 생성하는 것이 아니라 외부에서 넣어주게 만들자
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
       //같은 이름이 있는 중복회원은 안된다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId(); //임의로 ID를 반환
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m ->{ //Optional로 감싸서 ifPresent같은 것들을 쓸 수 있다.
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
