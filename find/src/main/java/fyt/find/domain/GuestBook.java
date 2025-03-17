package fyt.find.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName   : fyt.find.domain
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */

@Builder
@Getter
public class GuestBook {

    private Long id;
    private Long OwnerId; // 방명록 주인
    private List<Comment> comments;

    public static GuestBook build(Long id, Long OwnerId) {
        return GuestBook.builder()
                .id(id)
                .OwnerId(OwnerId)
                .build();
    }

    public void addComment(Comment comment){
        if (comments == null) {
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

    // 작성자가 쓴 댓글 찾기
    public Comment findByWriterId(Long writerId) {
        return comments.stream()
                .filter(comment -> comment.getWriterId().equals(writerId))
                .findFirst()
                .orElse(null);
    }

    public Comment findById(Long commentId){
        return comments.stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .orElse(null);
    }

}
