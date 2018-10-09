package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter @Setter
@Table(name="Preorder")
public class Preorder{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long preId;
    private @NonNull String preName;
    private double sumPrice;
    private long num;

    @ManyToOne()   
    @JoinColumn(name= "statusId")     
    private StatusPreorder statusPreorder;
    
    @ManyToOne() 
    @JoinColumn(name= "userId")     
    private User user;

    @ManyToMany(cascade = { 
        CascadeType.PERSIST, 
        CascadeType.MERGE
    })
    @JoinTable(name = "productPreorder",
        joinColumns = @JoinColumn(name = "preId"),
        inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products = new ArrayList<>();
    
    public Preorder(){}
}