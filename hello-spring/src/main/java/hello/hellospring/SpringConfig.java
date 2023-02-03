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

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    private EntityManager em;

    @Bean //스프링 bean을 내가 등록하겠다.
    public MemberService memberService() {
        return new MemberService(memberRepository()); //Autowired랑 같은 효과
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
