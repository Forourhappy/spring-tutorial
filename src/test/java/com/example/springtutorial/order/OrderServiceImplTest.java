package com.example.springtutorial.order;

import com.example.springtutorial.AppConfig;
import com.example.springtutorial.discount.FixDiscountPolicy;
import com.example.springtutorial.member.Grade;
import com.example.springtutorial.member.Member;
import com.example.springtutorial.member.MemberService;
import com.example.springtutorial.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {


    @Test
    void createOrder() {

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));


        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()). isEqualTo(1000);
    }
}
