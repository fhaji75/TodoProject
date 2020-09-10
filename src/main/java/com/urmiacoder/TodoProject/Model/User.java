package com.urmiacoder.TodoProject.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userInformation")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String descriptionOfDuty;

    public User(){
        super();
    }
    public User(Long id,String descriptionOfDuty){
        super();
        this.id=id;
        this.descriptionOfDuty=descriptionOfDuty;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionOfDuty() {
        return descriptionOfDuty;
    }

    public void setDescriptionOfDuty(String descriptionOfDuty) {
        this.descriptionOfDuty = descriptionOfDuty;
    }

}