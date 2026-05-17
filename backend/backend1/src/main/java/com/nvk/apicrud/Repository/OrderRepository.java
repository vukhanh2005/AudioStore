package com.nvk.apicrud.Repository;

import com.nvk.apicrud.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAccountIdOrderByCreatedAtDesc(Integer accountId);
}
