package com.example.kakao.Order;

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
@Table(name="order_tb")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    // user fk 구현해야함
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public Order(int orderId, User user, LocalDateTime date){
        this.orderId = orderId;
        this.user = user;
        this.date = date;
    }
}
