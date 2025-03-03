package fyt.find.service;

import fyt.find.domain.Member;

/**
 * packageName   : fyt.find.service
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
