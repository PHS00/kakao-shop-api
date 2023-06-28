package com.example.kakao.Option;

import com.example.kakao.product.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="option_tb")
public class Option {
    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionId;

    // product fk 구현해야함
    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @Column(name = "option_name", length = 256, nullable = false)
    private String optionName;

    @Column(name = "option_price", length = 45, nullable = false)
    private int optionPrice;

    @Column(name = "option_stock", length = 45, nullable = false)
    private int optionStock;

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public Option(int optionId, String optionName, Product product, int optionPrice, int optionStock, LocalDateTime date){
        this.optionId = optionId;
        // product fk 구현필요
        this.product = product;
        this.optionName = optionName;
        this.optionPrice = optionPrice;
        this.optionStock = optionStock;
        this.date = date;
    }
}
