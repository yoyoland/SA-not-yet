package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Entity
@Getter @Setter
@Table(name="Status")
public class User{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull Long userId;
    private @NonNull String userName;
    private String userAddress;
    private @NonNull String userEmail;
    private @NonNull Long userTel;


    @ManyToOne()   
    @JoinColumn(name= "provinceId")     
    private Province province;

    public User(){}
    public User(String userName){
        this.userName = userName;
        
    }
    public User(Long userId){
        this.userId = userId;
    }
    public User(String userName,String userAddress,Long provinceId,String userEmail,Long userTel){
        Province province = new Province(provinceId);
        this.userName = userName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userTel = userTel;
        this.province = province;
    }
}