package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }//springdatajpa가 만들어놓은 구현체가 등록이 된다.

    @Bean //스프링 bean을 내가 등록하겠다.
    public MemberService memberService() {
        return new MemberService(memberRepository); //Autowired랑 같은 효과
    }

    /*@Bean
    public MemberRepository memberRepository() {
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}
