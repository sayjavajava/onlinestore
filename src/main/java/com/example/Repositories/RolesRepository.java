package com.example.Repositories;

import com.example.Domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by waqas on 03/03/2017.
 */
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Roles findByRole(String role);

}
