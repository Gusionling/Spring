package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,2 키 값을 생성해주는 아이이다.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null이 반환될 가능성 때문에 Otional.ofNullable
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()   //loop를 돌면서 찾는다.
                .filter(member -> member.getName().equals(name))
                .findAny(); //findAny는 하나라도 찾는 것이다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear(); //store을 비워준다.
    }
}
