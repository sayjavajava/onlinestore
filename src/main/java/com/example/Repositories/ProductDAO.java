package com.example.Repositories;

import com.example.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by waqas on 24/02/2017.
 */
public interface ProductDAO extends JpaRepository<Product, Integer>  {


}
