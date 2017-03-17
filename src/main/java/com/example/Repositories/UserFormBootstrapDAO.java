package com.example.Repositories;

import com.example.Domain.UserForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by waqas on 28/02/2017.
 */
public interface UserFormBootstrapDAO extends JpaRepository<UserForm,Integer> {


    public List<UserForm> findByLastname(String lastname);
    public List<UserForm> findByEmail(String email);


}
