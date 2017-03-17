package com.example.Domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by waqas on 13/03/2017.
 */
@Entity
public class OrderDetail {

     @Id
     @GeneratedValue
     private Integer id;

    /*@ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
*/
    @ManyToOne
    @JoinColumn(name="orderitem")
    private orderitem orderitem;

     @ManyToOne
     @JoinColumn(name="purchased_By")
     private user PurchasedBy;

@OneToMany(cascade = CascadeType.ALL)
@JoinTable( name = "user_vehical",joinColumns=@JoinColumn(name = "order_id"),inverseJoinColumns =@JoinColumn(name = "product_id"))
private Collection<Product> productlist = new ArrayList<Product>();

    public Collection<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(Collection<Product> productlist) {
        this.productlist = productlist;
    }

    private Integer quantity;

    private Integer price;

    @Temporal(TemporalType.DATE)
    private Date date;

   public OrderDetail(){}

    public OrderDetail(Product product, user purchasedBy, Integer quantity, Integer price, Date date) {
        //this.product = product;
        PurchasedBy = purchasedBy;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public com.example.Domain.orderitem getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(com.example.Domain.orderitem orderitem) {
        this.orderitem = orderitem;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.example.Domain.user getUser() {
        return PurchasedBy;
    }

    public void setUser(com.example.Domain.user user) {
        this.PurchasedBy = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
