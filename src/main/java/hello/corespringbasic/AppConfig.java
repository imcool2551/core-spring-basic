package hello.corespringbasic;

import hello.corespringbasic.discount.DiscountPolicy;
import hello.corespringbasic.discount.FixDiscountPolicy;
import hello.corespringbasic.member.MemberService;
import hello.corespringbasic.member.MemberServiceImpl;
import hello.corespringbasic.member.MemoryMemberRepository;
import hello.corespringbasic.order.OrderService;
import hello.corespringbasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
