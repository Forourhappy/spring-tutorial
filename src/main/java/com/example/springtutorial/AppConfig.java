package com.example.springtutorial;

import com.example.springtutorial.discount.FixDiscountPolicy;
import com.example.springtutorial.discount.RateDiscountPolicy;
import com.example.springtutorial.member.MemberService;
import com.example.springtutorial.member.MemberServiceImpl;
import com.example.springtutorial.member.MemoryMemberRepository;
import com.example.springtutorial.order.OrderService;
import com.example.springtutorial.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    private static RateDiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

}
