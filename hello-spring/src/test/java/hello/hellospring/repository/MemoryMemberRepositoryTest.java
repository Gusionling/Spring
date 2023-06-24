package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest { //class레벨에서 돌리면 테스트 케이스들을 다 돌려볼 수 있다.
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach //메서드가 끝날 때마다 실행이 되는 것 call back 메서드라고 보면된다.
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    //메인 메서드 쓰는거랑 비슷하다.
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //optional에서 값을 꺼낼 때 get으로 값을 꺼낼 수 있다.
        Assertions.assertEquals(member, result); //member와 result가 같은지를 비교해주는
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
