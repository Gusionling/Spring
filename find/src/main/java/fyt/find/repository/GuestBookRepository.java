package fyt.find.repository;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;

import java.util.List;

/**
 * packageName   : fyt.find.repository
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */
public interface GuestBookRepository {

    void save(GuestBook guestBook);

    GuestBook findById(Long id);

    GuestBook findByOwnerId(Long ownerId);

}
