package com.example.Services;

import com.example.Domain.Roles;
import com.example.Domain.user;

import java.util.List;

/**
 * Created by waqas on 03/03/2017.
 */
public interface User_Service {

    public user findByEmail(String email);
    public void save(user user);

}
