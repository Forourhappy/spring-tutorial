package com.example.springtutorial.discount;

import com.example.springtutorial.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
