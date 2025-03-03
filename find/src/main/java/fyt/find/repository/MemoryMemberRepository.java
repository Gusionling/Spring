package fyt.find.repository;

import fyt.find.domain.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * packageName   : fyt.find.repository
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */
public class MemoryMemberRepository implements MemberRepository{

    // 모든 객체가 공유해야 하기 때문에 static
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
