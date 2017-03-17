package com.example.Services;

import com.example.Domain.UserForm;
import com.example.Domain.User_Detail;
import com.example.Repositories.UserFormBootstrapDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by waqas on 28/02/2017.
 */
@Service
@Transactional
public class UserFormService {

    @Autowired
    private UserFormBootstrapDAO userFormBootstrapDAO;

    public String save(UserForm product){
        userFormBootstrapDAO.save(product);
        return "task-saved";
    }

    public List<UserForm> findByLastName(String name){
        List<UserForm> list= userFormBootstrapDAO.findByLastname(name);
        return list;
    }

    public List<UserForm> findByEmail(String email){
        List<UserForm> list= userFormBootstrapDAO.findByEmail(email);
        return list;
    }
    public List<UserForm> AllGuests(){
        List<UserForm> list= userFormBootstrapDAO.findAll();
        return list;
    }
}
