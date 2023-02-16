package com.example.springtutorial.order;

import com.example.springtutorial.discount.DiscountPolicy;
import com.example.springtutorial.discount.FixDiscountPolicy;
import com.example.springtutorial.discount.RateDiscountPolicy;
import com.example.springtutorial.member.Member;
import com.example.springtutorial.member.MemberRepository;
import com.example.springtutorial.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice =  discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
