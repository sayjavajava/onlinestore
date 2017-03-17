package com.example.Repositories;

import com.example.Domain.orderitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by waqas on 13/03/2017.
 */
@Repository
public interface OrderItemDAO extends JpaRepository<orderitem,Integer> {
}
