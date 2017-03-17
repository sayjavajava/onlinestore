package com.example.Repositories;

import com.example.Domain.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by waqas on 13/03/2017.
 */
@Repository
public interface OrderDetailDAO extends PagingAndSortingRepository<OrderDetail,Integer>,JpaRepository<OrderDetail,Integer> {


}
