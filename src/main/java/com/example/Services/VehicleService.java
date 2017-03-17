package com.example.Services;

import com.example.Domain.Vehical;
import com.example.Repositories.User_DetailDAO;
import com.example.Repositories.VehicalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by waqas on 26/02/2017.
 */
@Service
@Transactional
public class VehicleService {


   private VehicalDao vehicalDao;
   private User_DetailDAO user_detailDAO;

    @Autowired
    public VehicleService(VehicalDao vehicalDao, User_DetailDAO user_detailDAO) {
        this.vehicalDao = vehicalDao;
        this.user_detailDAO = user_detailDAO;
    }

    public List<Vehical> findAll(){
        List<Vehical> list =  vehicalDao.findAll();
        return list;}

    public String save(Vehical product){
       // product.setUser_detail(user_detailDAO.findOne(product.getUserid()));
        vehicalDao.save(product);
        return "task-saved";
    }
    public String delete(int id){
        vehicalDao.delete(id);
        return "task-saved";
    }

    public Vehical findById(int id){
        Vehical list = vehicalDao.findOne(id);
        return list;
    }

}
