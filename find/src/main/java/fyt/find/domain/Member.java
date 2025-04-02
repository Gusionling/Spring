package fyt.find.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * packageName   : fyt.find.domain
 * Author        : imhyeong-gyu
 * Data          : 2025. 3. 3.
 * Description   : 사용자 정보
 */

@Getter
@Builder
public class Member {

    private Long id;
    private String name;
    private String password;

}
