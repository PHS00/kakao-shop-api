package com.example.kakao.OrderItem;

import com.example.kakao.Option.Option;
import com.example.kakao.Order.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="order_item_tb")
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

    @JoinColumn(name = "option_id")
    @OneToOne
    private Option option;

    @Column(name = "option_number", length = 245, nullable = false)
    private int optionNumber;

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public OrderItem(int orderItemId, Order order, Option option, int optionNumber, LocalDateTime date){
        this.orderItemId = orderItemId;
        this.order = order;
        this.option = option;
        this.optionNumber = optionNumber;
        this.date = date;
    }

}
