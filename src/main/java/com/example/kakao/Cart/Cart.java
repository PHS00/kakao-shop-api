package com.example.kakao.Cart;

import com.example.kakao.Option.Option;
import com.example.kakao.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="cart_tb")
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    // user fk 구현해야함
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    // option fk 구현해야함
    @JoinColumn(name = "option_id")
    @OneToOne
    private Option option;



    @Column(name = "option_number", length = 256, nullable = false)
    private int optionNumber;

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public Cart(int cartId, User user, Option option, int optionNumber, LocalDateTime date){
        this.cartId = cartId;
        // user fk
        this.user = user;
        // option fk
        this.option = option;
        this.optionNumber = optionNumber;
        this.date = date;
    }

}
