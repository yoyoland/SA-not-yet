package sut.sa.g21.entity;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "StatusPreorder")
public class StatusPreorder{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @NonNull long statusId;
    private @NonNull String statusName;
    
    protected StatusPreorder(){}
    public StatusPreorder(String statusName){
        this.statusName = statusName;
    }
    public StatusPreorder(long statusId){
        this.statusId = statusId;
    }   
}