package hello.corespringbasic.singleton;

import hello.corespringbasic.AppConfig;
import hello.corespringbasic.member.MemberRepository;
import hello.corespringbasic.member.MemberServiceImpl;
import hello.corespringbasic.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = ac.getBean("memberRepository", MemberRepository.class);
        MemberRepository memberRepository2 = memberService.getMemberRepository();
        MemberRepository memberRepository3 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository1);
        System.out.println("memberService -> memberRepository = " + memberRepository2);
        System.out.println("orderService -> memberRepository = " + memberRepository3);

        assertThat(memberRepository1).isSameAs(memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository3);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass());
    }
}
