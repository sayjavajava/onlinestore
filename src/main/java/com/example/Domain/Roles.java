package com.example.Domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by waqas on 03/03/2017.
 */
@Entity
@Table(name="role")
public class Roles extends AbstractPersistable<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;

    @NotEmpty(message = "role is essential ")
    @Column(name = "role")
    private String role;

    public Roles(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public Roles(){}

}
