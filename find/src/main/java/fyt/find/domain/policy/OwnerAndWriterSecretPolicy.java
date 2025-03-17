package fyt.find.domain.policy;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;
import fyt.find.domain.Member;

/**
 * packageName   : fyt.find.domain.policy
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */
public class OwnerAndWriterSecretPolicy implements SecretPolicy{


    @Override
    public boolean canRead(Comment comment, Member viewer, Long ownerId) {
        // 비밀글이 아니면 누구나 읽기 가능
        if (!comment.isSecret()) {
            return true;
        }

        // viewer가 없으면 읽기 불가
        if (viewer == null) {
            return false;
        }

        // 비밀글은 방명록 주인이거나 댓글 작성자만 읽기 가능
        return viewer.getId().equals(ownerId) ||
                viewer.getId().equals(comment.getWriterId());
    }
}
