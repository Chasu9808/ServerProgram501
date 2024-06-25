package com.busanit501.boot501.shop.repository;


import com.busanit501.boot501.shop.entity.ShopMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopMemberRepository extends JpaRepository<ShopMember, Long> {

    ShopMember findByEmail(String email);

}