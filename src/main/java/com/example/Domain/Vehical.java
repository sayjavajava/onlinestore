package com.example.Domain;
import javax.persistence.*;

@Entity
public class Vehical {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private transient  Integer userid;

    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    @ManyToOne
    @JoinColumn(name="USER_DETAIL_ID_fk")
    private User_Detail user_detail;

    public User_Detail getUser_detail() {
        return user_detail;
    }
    public void setUser_detail(User_Detail user_detail) {
        this.user_detail = user_detail;
    }

    private String vehicalname;
    public Vehical(){}

    public Vehical(String vehicalname) {
        this.vehicalname = vehicalname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehicalname() {
        return vehicalname;
    }
    public void setVehicalname(String vehicalname) {
        this.vehicalname = vehicalname;
    }
}
