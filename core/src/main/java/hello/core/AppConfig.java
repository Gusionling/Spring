package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    //이 코드가 들어가기 전에는 MemberServiceImpl에서 MemoryMemberRepository에 의존하고 있었다.
    //MemberServiceImpl에서 MemoryMemberRepository를 지우고 의존을 하지 않게한다.
    //생성자를 만든다.
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }



}
