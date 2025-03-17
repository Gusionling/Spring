package fyt.find.repository;

import fyt.find.domain.Comment;
import fyt.find.domain.GuestBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * packageName   : fyt.find.repository
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 6.
 * Description   :
 */
public class MemoryGuestBookRepository implements GuestBookRepository {

    private static final Map<Long, GuestBook> store = new HashMap<>();

    @Override
    public void save(GuestBook guestBook) {
        if (guestBook.getId() == null) {
            GuestBook newGuestBook = GuestBook.build(1L, guestBook.getOwnerId());
            store.put(1L, newGuestBook);

        }
        store.put(guestBook.getId(), guestBook);
    }

    @Override
    public GuestBook findById(Long id) {
        return store.get(id);
    }

    @Override
    public GuestBook findByOwnerId(Long ownerId) {
        return store.values().stream()
                .filter(guestBook -> guestBook.getOwnerId().equals(ownerId))
                .findFirst()
                .orElse(null);
    }

}
