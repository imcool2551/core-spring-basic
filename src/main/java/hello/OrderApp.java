package hello;

import hello.corespringbasic.member.Grade;
import hello.corespringbasic.member.Member;
import hello.corespringbasic.member.MemberService;
import hello.corespringbasic.member.MemberServiceImpl;
import hello.corespringbasic.order.Order;
import hello.corespringbasic.order.OrderService;
import hello.corespringbasic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
