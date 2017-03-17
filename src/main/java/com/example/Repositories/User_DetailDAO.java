package com.example.Repositories;

import com.example.Domain.User_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by waqas on 26/02/2017.
 */
public interface User_DetailDAO extends JpaRepository<User_Detail,Integer> {

    @Query("SELECT p FROM User_Detail p WHERE LOWER(p.productname) = LOWER(:lastName)")
     public List<User_Detail> findByName(@Param("lastName") String lastName);

}
