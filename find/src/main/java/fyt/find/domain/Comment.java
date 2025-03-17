package fyt.find.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName   : fyt.find.domain
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */

@Builder
@Getter
public class Comment {

    private Long id;
    private Long guestBookId;
    private Long writerId;
    private boolean isSecret;
    private String content;

    public static Comment build(Long id, Long guestBookId, Long writerId, Boolean isSecret, String content) {
        return Comment.builder()
                .id(id)
                .guestBookId(guestBookId)
                .writerId(writerId)
                .isSecret(isSecret)
                .content(content)
                .build();
    }
}
