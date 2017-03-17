package com.example.Domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by waqas on 26/02/2017.
 */

/**
 * Created by waqas on 26/02/2017.
 */
@Entity
@Table(name = "user")
public class user extends AbstractPersistable<Integer> {
//03008607214

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "PurchasedBy" ,cascade = CascadeType.ALL)
    private Collection<OrderDetail> orderDetail = new ArrayList<OrderDetail>();

    public Collection<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Collection<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @org.springframework.data.annotation.Transient
    private String password;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    @Column(name = "active")
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

}
