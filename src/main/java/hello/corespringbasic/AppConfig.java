package hello.corespringbasic;

import hello.corespringbasic.discount.DiscountPolicy;
import hello.corespringbasic.discount.RateDiscountPolicy;
import hello.corespringbasic.member.MemberService;
import hello.corespringbasic.member.MemberServiceImpl;
import hello.corespringbasic.member.MemoryMemberRepository;
import hello.corespringbasic.order.OrderService;
import hello.corespringbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
