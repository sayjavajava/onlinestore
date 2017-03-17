package com.example.Services;

import com.example.Domain.Product;
import com.example.Repositories.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by waqas on 24/02/2017.
 */
@Service
@Transactional
public class ProductService  {

    @Autowired
    ProductDAO productDAO;


    public List<Product> findAll(){
    List<Product> list =  productDAO.findAll();
    return list;}

    public String save(Product product){
        productDAO.save(product);
        return "task-saved";
    }
    public String delete(int id){
        productDAO.delete(id);
        return "task-deleted";
    }

    public Product findById(int id){
    Product list = productDAO.findOne(id);
    return list;
    }

}
