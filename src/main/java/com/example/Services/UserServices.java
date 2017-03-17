package com.example.Services;

import com.example.Domain.Roles;
import com.example.Domain.User_Detail;
import com.example.Domain.user;
import com.example.Repositories.RolesRepository;
import com.example.Repositories.UserRepository;
import com.example.Repositories.User_DetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by waqas on 03/03/2017.
 */
@Service
public class UserServices implements User_Service {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public user findByEmail(String email) {
     return userRepository.findByEmail(email);
    }

    @Override
    public void save(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        System.out.println("the selected "+ user.getRoles());
        Roles role = rolesRepository.findByRole("USER");
        //user.setRole(new HashSet<Roles>(Arrays.asList(role)));
        user.setRoles(new HashSet<Roles>(Arrays.asList(role)));
        userRepository.save(user);
    }
public List<user> findByNameAndSort(String email){
    return userRepository.findByAndSort(email,new Sort("name"));
}
public List<user> findAllUsers(){
    return userRepository.findAll();
}



}
