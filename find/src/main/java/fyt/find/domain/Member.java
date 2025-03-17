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
    private MemberType memberType;
    private String name;
    private String password;


    // 기본 값은 GUEST
    public static Member build(Long id,String name, String password) {
        return Member.builder()
                .id(id)
                .memberType(MemberType.GUEST)
                .name(name)
                .password(password)
                .build();
    }

    public static Member buildOwner(Long id,String name, String password) {
        return Member.builder()
                .id(id)
                .memberType(MemberType.OWNER)
                .name(name)
                .password(password)
                .build();
    }


    public enum MemberType{
        GUEST, OWNER
    }

    public boolean isOwner(){
        return this.memberType == MemberType.OWNER;
    }

}
