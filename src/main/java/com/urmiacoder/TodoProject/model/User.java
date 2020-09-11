package com.urmiacoder.TodoProject.model;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="userInformation")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(targetEntity = Task.class)
    private List<Task> tasks;

    public User(){
        super();
    }
    public User(Long id,String name){
        super();
        this.id=id;
        this.name =name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}