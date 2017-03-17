package com.example.Services;

import com.example.Domain.*;
import com.example.Domain.Product;
import com.example.Repositories.OrderDetailDAO;
import com.example.Repositories.OrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by waqas on 13/03/2017.
 */
@Service
public class OrderDetailservice {

    @Autowired
    OrderDetailDAO orderDetailDAO;
    @Autowired
    private Cart cart;

    @Autowired
    private OrderItemDAO orderItemDAO;

    public String palaceorder(Map<Product,Integer> allcollection, user userid){
    OrderDetail orderDetaildomain = new OrderDetail();
    Date now = new Date();
        orderitem orderitem  = new orderitem();
    for(Map.Entry<Product,Integer> entry : allcollection.entrySet()) {

        orderDetaildomain.setQuantity(cart.getCartSize());
     // orderDetaildomain.setProduct(entry.getKey());
        orderDetaildomain.setPrice(((int) cart.getTotalCost()));
        orderDetaildomain.setUser(userid);
        orderDetaildomain.setDate(now);
      // System.err.println("items"+orderDetaildomain.getProduct().getId());
       // orderitem.setProduct(entry.getKey());
        orderDetaildomain.setOrderitem(orderitem);
        orderDetaildomain.getProductlist().add(entry.getKey());
        orderItemDAO.save(orderitem);
    }

         orderDetailDAO.save(orderDetaildomain);
        return null;
}
public Page<OrderDetail> findAll(Pageable pageable){
    return orderDetailDAO.findAll(pageable);
}
public List<OrderDetail> findAllOrdsers(){
    return orderDetailDAO.findAll();
}
}
