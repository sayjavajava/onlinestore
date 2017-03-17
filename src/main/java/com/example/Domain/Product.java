package com.example.Domain;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Product implements Serializable {
/*@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;*/


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Product name must not be null")
    @NotEmpty
    private String name;

    private String description;
    @NotNull(message = "Image source can not be null")
    private String imageUrl;

    @Min(value = 0,message = "Price can not be less than zero ")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Transient
    private String extention;

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }
    public Product(){}
    public Product(String name, String description, String imageUrl, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
        return name;
    }

 public void setName(String name) {
        this.name = name;
    }

 public String getImageUrl() {
return imageUrl;
}

public void setImageUrl(String imageUrl) {
this.imageUrl = imageUrl;
}

public BigDecimal getPrice() {
return price;
}

public void setPrice(BigDecimal price) {
this.price = price;
}
}
