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
@Table(name="Product")
public class Product{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long productId;
    private @NonNull String productName;   
    private String productDetail;
    private double productPrice;
    private String productImgUrl;

    @ManyToMany(mappedBy = "products")
    private List<Preorder> preorders = new ArrayList<>();
 
    public Product(){}
}