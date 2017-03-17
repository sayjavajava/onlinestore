package com.example.Domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class User_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productname;

    @OneToMany(mappedBy = "user_detail" ,cascade = CascadeType.ALL)
    private Collection<Vehical> Vehical = new ArrayList<Vehical>();

    public Collection<com.example.Domain.Vehical> getVehical() {
        return Vehical;
    }

    public void setVehical(Collection<com.example.Domain.Vehical> vehical) {
        Vehical = vehical;
    }
    public User_Detail(){}

    public User_Detail(String productname) {
        this.productname = productname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}
