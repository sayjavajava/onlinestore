package com.example.Domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a categorization of products
 *
 * @author Biju Kunjummen
 */
@Entity
@Table(name = "orderitem")
public class orderitem implements Serializable{

    private static final long serialVersionUID = 7433718480273391755L;

    @Id
    @JoinTable
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "orderitem" ,cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail = new ArrayList<OrderDetail>();

    public orderitem(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public orderitem(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
