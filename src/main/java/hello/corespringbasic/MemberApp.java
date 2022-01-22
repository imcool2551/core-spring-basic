package hello.corespringbasic;

import hello.corespringbasic.member.Grade;
import hello.corespringbasic.member.Member;
import hello.corespringbasic.member.MemberService;
import hello.corespringbasic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
