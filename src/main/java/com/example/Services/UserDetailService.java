package com.example.Services;

import com.example.Domain.User_Detail;
import com.example.Repositories.User_DetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by waqas on 26/02/2017.
 */
@Service
@Transactional
public class UserDetailService {
@Autowired
private User_DetailDAO user_detailDAO;

    public List<User_Detail> findAll(){
        List<User_Detail> list =  user_detailDAO.findAll();
        return list;}

    public String save(User_Detail product){
        user_detailDAO.save(product);
        return "task-saved";
    }
    public String delete(int id){
        user_detailDAO.delete(id);
        return "deleted";
    }

    public User_Detail findById(int id){
        User_Detail list = user_detailDAO.findOne(id);
        return list;
    }

    public List<User_Detail> findByName(String name){
        List<User_Detail> list= user_detailDAO.findByName(name);
        return list;
    }





}
