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


public interface SecretPolicy {

    //해당 방명록을 읽을 수 있는지 확인
    boolean canRead(Comment comment, Member viewer, Long ownerId);


}
