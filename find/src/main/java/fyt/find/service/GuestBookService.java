package fyt.find.service;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;
import fyt.find.domain.Member;
import fyt.find.domain.policy.OwnerOnlySecretPolicy;
import fyt.find.domain.policy.SecretPolicy;
import fyt.find.repository.GuestBookRepository;
import fyt.find.repository.MemoryGuestBookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName   : fyt.find.service
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */
public class GuestBookService {

    private final GuestBookRepository guestBookRepository = new MemoryGuestBookRepository();
    private final SecretPolicy secretPolicy = new OwnerOnlySecretPolicy();

    //guestBook 을 저장한다.
    public void createGuestBook(GuestBook guestBook) {
        guestBookRepository.save(guestBook);
    }

    //방명록에 comment 를 저장한다. <- but 현재는 그냥 생성시에
    public void addComment(Long guestBookId, Comment comment) {
        GuestBook guestBook = guestBookRepository.findById(guestBookId);
        guestBook.addComment(comment);
    }

    // 주인 id 로 comment 를 찾는다.
    public List<Comment> findCommentsByOwnerId(Long ownerId) {
        GuestBook guestBook = guestBookRepository.findByOwnerId(ownerId);
        if (guestBook == null || guestBook.getComments() == null) {
            return Collections.emptyList();
        }
        return new ArrayList<>(guestBook.getComments());
    }

    // comment 를 읽는다.
    public String read(Long guestBookId, Long commentId, Member viewer) {

        GuestBook guestBook = guestBookRepository.findById(guestBookId);
        Comment comment = guestBook.findCommentByCommentId(commentId);

        if (comment == null) {
            throw new IllegalArgumentException("존재하지 않는 댓글입니다: " + commentId);
        }

        // 비밀글 정책 적용 (OCP)
        if (!secretPolicy.canRead(comment, viewer, guestBook.getOwnerId())) {
            return "[비밀 댓글입니다]";
        }

        return comment.getContent();
    }
}
