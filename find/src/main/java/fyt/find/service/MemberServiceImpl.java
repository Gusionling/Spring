package fyt.find.service;

import fyt.find.domain.Member;
import fyt.find.repository.MemberRepository;
import fyt.find.repository.MemoryMemberRepository;

/**
 * packageName   : fyt.find.service
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
