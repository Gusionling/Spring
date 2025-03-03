package fyt.find.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName   : fyt.find.domain
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   :
 */

@Getter
@Builder
public class Member {

    private Long id;
    private String name;
    private String password;

    public static Member build(Long id, String name, String password) {
        return Member.builder()
                .id(id)
                .name(name)
                .password(password)
                .build();
    }

}
