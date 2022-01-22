package hello.corespringbasic.discount;

import hello.corespringbasic.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @return 할인 금액
     */
    int discount(Member member, int price);
}
