package com.example.kakao.product;

import com.example.kakao.user.StringArrayConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "product_name", length = 100, nullable = false)
    private String productName; // 인증시 필요한 필드

    @Column(name = "product_image", length = 256, nullable = false)
    private String productImage;

    @Column(name = "product_price", length = 45, nullable = false)
    private int productPrice;

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public Product(int productId, String productName, String productImage, int productPrice, LocalDateTime date) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.date = date;
    }
}
