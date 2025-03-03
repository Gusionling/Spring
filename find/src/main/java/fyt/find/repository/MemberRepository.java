package fyt.find.repository;

import fyt.find.domain.Member;

/**
 * packageName   : fyt.find.repository
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */
public interface MemberRepository {

    void save(Member member);
    Member findById(Long id);
}
