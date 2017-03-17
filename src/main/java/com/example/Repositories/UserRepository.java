package com.example.Repositories;

import com.example.Domain.user;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by waqas on 03/03/2017.
 */
public interface UserRepository extends JpaRepository<user,Integer> {

    user findByEmail(String email);

    @Query("select u from user u where u.email like ?1%")
    List<user> findByAndSort(String lastname, Sort sort);
}
