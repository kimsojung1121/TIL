package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    //F2 오류 발생 코드로 이동

    /**
     *
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);

}
