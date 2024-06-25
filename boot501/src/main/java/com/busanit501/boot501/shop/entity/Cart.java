package com.busanit501.boot501.shop.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter
@ToString
public class Cart extends BaseEntity {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private ShopMember shopMember;

    public static Cart createCart(ShopMember shopMember){
        Cart cart = new Cart();
        cart.setShopMember(shopMember);
        return cart;
    }

}