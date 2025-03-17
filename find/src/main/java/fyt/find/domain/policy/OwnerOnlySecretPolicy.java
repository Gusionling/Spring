package fyt.find.domain.policy;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;
import fyt.find.domain.Member;
import fyt.find.repository.MemberRepository;
import fyt.find.repository.MemoryMemberRepository;

/**
 * packageName   : fyt.find.domain.policy
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */
public class OwnerOnlySecretPolicy implements SecretPolicy{

    @Override
    public boolean canRead(Comment comment, Member viewer, Long ownerId) {

        if (!comment.isSecret()) {
            return true;
        }

        // viewer가 없으면 읽기 불가
        if (viewer == null) {
            return false;
        }

        // 비밀글은 방명록 주인만 읽기 가능
        return viewer.getId().equals(ownerId);

    }
}
