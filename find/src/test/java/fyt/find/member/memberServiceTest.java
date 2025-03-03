package fyt.find.member;

import fyt.find.domain.Member;
import fyt.find.service.MemberService;
import fyt.find.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * packageName   : fyt.find.member
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */
public class memberServiceTest {

    private final MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        //given
        Member member = Member.build(1L, "홍길동", "1234");

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
