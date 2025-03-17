package fyt.find.secretPolicy;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;
import fyt.find.domain.Member;
import fyt.find.service.GuestBookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.TRUE;

/**
 * packageName   : fyt.find.secretPolicy
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 7.
 * Description   :
 */
public class SecretPolicyServiceTest {

    private final GuestBookService guestBookService = new GuestBookService();

    // 테스트에서 공유할 필드 선언
    private Member owner;
    private Member visitor;
    private GuestBook guestBook;
    private Comment comment;

    @BeforeEach
    void initData(){
        owner = Member.build(1L, "홍길동", "1234");
        visitor = Member.build(2L, "방문자1", "1234");

        guestBook = GuestBook.build(1L, 1L);
        guestBookService.createGuestBook(guestBook);

        comment = Comment.build(1L, 1L, 2L, TRUE, "잘 보고 갑니다");
        guestBookService.addComment(comment.getGuestBookId(), comment);
    }


    @Test
    void createComment(){
        Comment findContent = guestBook.findByWriterId(visitor.getId());
        Assertions.assertThat(comment).isEqualTo(findContent);
    }

    @Test
    void read(){
        String content = guestBookService.read(guestBook.getId(), comment.getId(), visitor);
        Assertions.assertThat(content).isEqualTo("[비밀 댓글입니다]");

        // 방명록 주인은 비밀글을 읽을 수 있음
        String ownerView = guestBookService.read(guestBook.getId(), comment.getId(), owner);
        Assertions.assertThat(ownerView).isEqualTo("잘 보고 갑니다");
    }
}
